package com.funny.admin.common.domain.wx;

import java.io.Serializable;
import java.util.Date;

public class WeixinToken implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -2743355940017395935L;
    
    private Integer id;

    private String token;


    private Integer expiresIn;


    private Date tokenTime;

    public String getToken() {
        return token;
    }


    public void setToken(String token) {
        this.token = token;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }


    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }


    public Date getTokenTime() {
        return tokenTime;
    }

    public void setTokenTime(Date tokenTime) {
        this.tokenTime = tokenTime;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }
}