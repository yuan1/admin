package com.funny.admin.service.wx.impl;


import com.funny.admin.dao.wx.WeixinMessageMapper;
import com.funny.admin.domain.wx.WeixinMessage;
import com.funny.admin.domain.wx.WeixinToken;
import com.funny.admin.service.wx.WeixinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WeixinServiceImpl implements WeixinService {
    
    @Autowired
    private WeixinMessageMapper weixinMessageMapper;

    @Override
    public int insert(WeixinMessage record) {
        return weixinMessageMapper.insert(record);
    }

    @Override
    public List<WeixinMessage> selectMessagePage(Integer startIndex,Integer pageSize) {
        return weixinMessageMapper.selectMessagePage(startIndex,pageSize);
    }

    @Override
    public int count() {
        return weixinMessageMapper.count();
    }

    @Override
    public int insertToken(WeixinToken record) {
        return weixinMessageMapper.insertToken(record);
    }

    @Override
    public int updateToken(WeixinToken record) {
        return weixinMessageMapper.updateToken(record);
    }

    @Override
    public WeixinToken selectToken() {
        return weixinMessageMapper.selectToken();
    }

}
