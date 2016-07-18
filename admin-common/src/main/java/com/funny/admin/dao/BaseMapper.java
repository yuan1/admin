package com.funny.admin.dao;

import com.funny.admin.domain.BaseEntity;

import java.util.List;

/**
 * Created by fangli@autohome.com.cn on 2016/6/29.
 */
public interface BaseMapper<T extends BaseEntity> {

    int insert(T t);

    int updateByIdSelected(T t);

    int deleteById(Long id);

    T findById(Long id);

    int count();

    List<T> findAll();
}
