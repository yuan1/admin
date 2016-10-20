package com.funny.admin.common.service;

import com.funny.admin.common.domain.BaseEntity;
import com.funny.admin.common.domain.PageCondition;
import com.github.pagehelper.PageInfo;

/**
 * Created by funny on 16/10/20.
 */
public interface BaseService<T extends BaseEntity, C extends PageCondition> {
    int add(T t);

    int update(T t);

    T findById(Long id);

    PageInfo<T> getPageList(C c);
}
