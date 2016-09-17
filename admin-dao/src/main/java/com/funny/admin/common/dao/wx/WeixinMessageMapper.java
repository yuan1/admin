package com.funny.admin.common.dao.wx;


import com.funny.admin.common.domain.wx.WeixinMessage;
import com.funny.admin.common.domain.wx.WeixinToken;

import java.util.List;

public interface WeixinMessageMapper {

    int insert(WeixinMessage record);

    int count();

    List<WeixinMessage> selectMessagePage(Integer startIndex, Integer pageSize);

    int insertToken(WeixinToken record);

    int updateToken(WeixinToken record);

    WeixinToken selectToken();
}