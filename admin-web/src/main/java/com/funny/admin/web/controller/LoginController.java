package com.funny.admin.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.funny.admin.common.domain.admin.vo.MenuVo;
import com.funny.admin.service.sys.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.funny.admin.service.sys.MenuService;
import com.funny.admin.common.result.JsonResult;

@Controller
public class LoginController {
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);


    @Resource
    private MenuService menuService;
    @Resource
    private UserService userService;

    /**
     * 访问登录页
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toLogin")
    public ModelAndView toLogin() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    /**
     * 请求登录，验证用户
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    public String  login(HttpSession session,String username,String password,String randomcode) {

        //从session获取正确的验证码
        String validateCode = (String)session.getAttribute("validateCode");
        if(!randomcode.equals(validateCode)){
            //抛出异常：验证码错误
            throw new RuntimeException("请输入验证码!");
        }
        //用户身份认证
        //UserEntity activeUser = userService.authenticat(username, password);
        //记录session
        //session.setAttribute("activeUser", activeUser);
        return "redirect:/first";
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("/main")
    public ModelAndView main() {
        return new ModelAndView("main");
    }

    /**
     * 请求登录，验证用户
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/createMenuTree")
    @ResponseBody
    public JsonResult createMenuTree() {
        JsonResult jsonResult = new JsonResult();
        try {
            List<MenuVo> menuList = menuService.getMenuTree();
            jsonResult.setSuccess(menuList);
        } catch (Exception e) {
            logger.error("获取菜单失败",e);
            jsonResult.setFail("获取菜单失败");
        }
        return jsonResult;
    }

    /**
     * 用户注销
     * 
     * @return
     */
    @RequestMapping(value = "/logout")
    public ModelAndView logout() {
        // String USERNAME = Jurisdiction.getUsername(); //当前登录的用户名
        ModelAndView mv = new ModelAndView();
        // Session session = Jurisdiction.getSession(); //以下清除session缓存
        // session.removeAttribute(Const.SESSION_USER);
        // session.removeAttribute(USERNAME + Const.SESSION_ROLE_RIGHTS);
        // session.removeAttribute(USERNAME + Const.SESSION_allmenuList);
        // session.removeAttribute(USERNAME + Const.SESSION_menuList);
        // session.removeAttribute(USERNAME + Const.SESSION_QX);
        // session.removeAttribute(Const.SESSION_userpds);
        // session.removeAttribute(Const.SESSION_USERNAME);
        // session.removeAttribute(Const.SESSION_USERROL);
        // session.removeAttribute("changeMenu");
        // //shiro销毁登录
        // Subject subject = SecurityUtils.getSubject();
        // subject.logout();
        // pd.put("msg", pd.getString("msg"));
        // pd.put("SYSNAME", Tools.readTxtFile(Const.SYSNAME)); //读取系统名称
        // mv.setViewName("system/index/login");
        // mv.addObject("pd",pd);
        return mv;
    }
}
