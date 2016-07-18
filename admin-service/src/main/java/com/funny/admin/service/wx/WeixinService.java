package com.funny.admin.service.wx;


import com.funny.admin.domain.wx.WeixinMessage;
import com.funny.admin.domain.wx.WeixinToken;

import java.util.List;

public interface WeixinService {

    int insert(WeixinMessage record);

    int count();

    List<WeixinMessage> selectMessagePage(Integer startIndex, Integer pageSize);

    int insertToken(WeixinToken record);

    int updateToken(WeixinToken record);

    WeixinToken selectToken();
}
