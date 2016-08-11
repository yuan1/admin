package com.funny.admin.dao.sys;

import com.funny.admin.condition.sys.DictCondition;
import com.funny.admin.dao.BaseMapper;
import com.funny.admin.domain.sys.Dict;

import java.util.List;

public interface DictMapper extends BaseMapper<Dict> {
    Dict getDictByDictId(Integer dictId);

    List<Dict> getPageDictList(DictCondition condition);
}