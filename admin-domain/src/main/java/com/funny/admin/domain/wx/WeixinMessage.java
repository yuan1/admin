package com.funny.admin.domain.wx;

import java.io.Serializable;
import java.util.Date;

public class WeixinMessage  implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 6032475959417657550L;

    private Integer id;

    private String nickName;

    private String headImgUrl;

    private Date createTime;

    private String content;

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getNickName() {
        return nickName;
    }


    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    public String getHeadImgUrl() {
        return headImgUrl;
    }


    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }
}