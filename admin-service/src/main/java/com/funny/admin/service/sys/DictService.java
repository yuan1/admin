package com.funny.admin.service.sys;

import com.funny.admin.domain.sys.condition.DictCondition;
import com.funny.admin.domain.sys.Dict;
import com.github.pagehelper.PageInfo;

public interface DictService {
    void addDict(Dict dict);

    void updateDict(Dict dict);

    Dict getDictById(Long id);

    Dict getDictByDictId(Integer dictId);

    PageInfo<Dict> getPageDictList(DictCondition condition);
}
