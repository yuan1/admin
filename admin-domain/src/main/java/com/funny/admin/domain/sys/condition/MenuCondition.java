package com.funny.admin.domain.sys.condition;

import com.funny.admin.domain.PageCondition;

/**
 * Created by fangli@autohome.com.cn on 2016/8/6.
 */
public class MenuCondition extends PageCondition {
    private Long parentId;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
