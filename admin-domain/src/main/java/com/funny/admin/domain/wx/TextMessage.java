package com.funny.admin.domain.wx;

import java.io.Serializable;

/**
 * 微信消息model
 * @author funny
 *
 */
public class TextMessage implements Serializable{
	/**
     * 
     */
    private static final long serialVersionUID = 7329454054751996760L;
	/**
	 * 发送目标
	 */
	private String ToUserName;
	/**
	 * 消息发送人
	 */
	private String FromUserName;
	/**
	 * 创建时间
	 */
	private Long CreateTime;
	/**
	 * 消息类型 
	 */
	private String MsgType;
	/**
	 * 文本消息内容
	 */
	private String Content;
	
    public String getToUserName() {
        return ToUserName;
    }
    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }
    public String getFromUserName() {
        return FromUserName;
    }
    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }
    
    public String getMsgType() {
        return MsgType;
    }
    public void setMsgType(String msgType) {
        MsgType = msgType;
    }
    public String getContent() {
        return Content;
    }
    public void setContent(String content) {
        Content = content;
    }
    public Long getCreateTime() {
        return CreateTime;
    }
    public void setCreateTime(Long createTime) {
        CreateTime = createTime;
    }
}
