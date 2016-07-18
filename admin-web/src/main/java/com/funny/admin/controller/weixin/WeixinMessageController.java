package com.funny.web.controller.weixin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funny.admin.domain.wx.WeixinMessage;
import com.funny.admin.domain.wx.WeixinToken;
import com.funny.admin.domain.wx.WeixinUser;
import com.funny.admin.service.wx.WeixinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.funny.WeixinUtil;
import com.funny.result.JsonResult;
import com.funny.utils.HttpUtils;
import com.funny.utils.dfa.DFAWordFilter;

/**
 * 接收微信公众好推送过来的消息
 * 
 * @author funny
 *
 */
@Controller
@RequestMapping("/api")
public class WeixinMessageController {
    private static final Logger logger = LoggerFactory.getLogger(WeixinMessageController.class);

    @Autowired
    private WeixinService weixinService;

    /**
     * get方法验证微信接口，post方法接收微信转发过来用户回复的消息
     * 
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    @RequestMapping("/weixin")
    @ResponseBody
    public String doWeixin(HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException {
        response.setCharacterEncoding("UTF-8");
        String result = null;
        if (request.getMethod() == RequestMethod.GET.toString()) {
            // 验证签名
            String signature = request.getParameter("signature");
            String timestamp = request.getParameter("timestamp");
            String nonce = request.getParameter("nonce");
            String echostr = request.getParameter("echostr");

            boolean res = WeixinUtil.checkSignature(signature, timestamp, nonce);
            if (res) {
                result = echostr;
            }
        }
        // 接收处理推送过来的消息
        else if (request.getMethod() == RequestMethod.POST.toString()) {
            try {
                Map<String, String> map = WeixinUtil.xmlToMap(request);
                String fromUserName = map.get("FromUserName");
                String msgType = map.get("MsgType");

                WeixinUser user = getUserInfo(fromUserName);
                WeixinMessage message = new WeixinMessage();

                message.setCreateTime(new Date());
                message.setNickName(user.getNickname());
                message.setHeadImgUrl(user.getHeadimgurl());
                if (WeixinUtil.MESSAGE_TEXT.equals(msgType)) {
                    String content = map.get("Content");
                    if (!content.contains("收到不支持") && !isContansEmoji(content)) {
                        content = DFAWordFilter.filter(content);
                        message.setContent(content);
                        weixinService.insert(message);
                    }
                }
            } catch (Exception e) {
                logger.error("/api/weixin/====>error:" + e.getMessage());
                e.printStackTrace();
            }
        }
        return JSON.toJSONString(result);
    }

    /**
     * 提供接口给web前端展示
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/messages")
    @ResponseBody
    public Object getMessages(HttpServletRequest request, HttpServletResponse response, Integer pageCount) {
        JsonResult<List<WeixinMessage>> result = new JsonResult<List<WeixinMessage>>();
        try {
            int realCount = weixinService.count();
            int pageSize = (realCount - pageCount) < 0 ? 0 : (realCount - pageCount);
            List<WeixinMessage> messagelist = weixinService.selectMessagePage(pageCount, pageSize);
            result.setSuccess(messagelist);
        } catch (Exception e) {
            result.setReturncode(500);
            e.printStackTrace();
            logger.error("/api/messages/===>error:" + e.getMessage());
        }
        return JSON.toJSONString(result);
    }

    /**
     * get AccessToken
     * 
     * @return
     * @throws IOException
     */
    private WeixinToken getAccessToken() throws  IOException {
        WeixinToken token = weixinService.selectToken();
        if (token == null) {
            token = getHttpToken();
            weixinService.insertToken(token);
        } else {
            // token 过了有效期 则取一个最新的token
            long expiretime = token.getTokenTime().getTime() + token.getExpiresIn() * 1000;
            if (new Date().after(new Date(expiretime))) {
                token = getHttpToken();
                weixinService.updateToken(token);
            }
        }
        return token;
    }

    private WeixinToken getHttpToken() {
        WeixinToken token = null;
        String url = WeixinUtil.ACCESS_TOKEN_URL.replace("APPID", WeixinUtil.APPID).replace("APPSECRET",
                WeixinUtil.APPSECRET);
        logger.info("获取token的url:" + url);
        String jsonObject = HttpUtils.httpGetData(url, null, "UTF-8");
        logger.info("获取token的结果:" + jsonObject);
        Map<String, Object> res = JSON.parseObject(jsonObject,Map.class);
        if (res.get("errcode") == null) {
            token = new WeixinToken();
            token.setTokenTime(new Date());
            token.setToken(res.get("access_token").toString());
            token.setExpiresIn(Integer.parseInt(res.get("expires_in").toString()));
        }
        return token;
    }

    /**
     * 获取userinfo
     * 
     * @param openid
     * @return
     * @throws IOException
     */
    private WeixinUser getUserInfo(String openid) throws  IOException {
        WeixinToken token = getAccessToken();
        String url = WeixinUtil.USER_DETAIL_URL.replace("ACCESS_TOKEN", token.getToken()).replace("OPENID", openid);
        String result = HttpUtils.httpGetData(url, null, "UTF-8");
        WeixinUser user =  JSON.parseObject(result, WeixinUser.class);
        return user;
    }

    /**
     * 功能：验证字符串字节长度是否符合要求，一个中文占3个字节
     * 
     * @author fangli
     * @param strParameter 要验证的字符串
     * @return 字符串的字节长度
     */
    public static int getStringLength(String strParameter) {
        int temp_int = 0;
        byte[] b = strParameter.getBytes();

        for (int i = 0; i < b.length; i++) {
            if (b[i] >= 0) {
                temp_int = temp_int + 1;
            } else {
                temp_int = temp_int + 2;
                i++;
            }
        }
        return temp_int;
    }

    /**
     * 判断文本中是否包含emoji表情
     * 
     * @param source
     * @return
     */
    public static boolean isContansEmoji(String source) {
        if (source != null) {
            Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
                    Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
            Matcher emojiMatcher = emoji.matcher(source);
            if (emojiMatcher.find()) {
                return true;
            }
            return false;
        }
        return false;
    }
}
