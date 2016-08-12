package com.funny.admin.service.sys.impl;

import com.funny.admin.condition.sys.DictCondition;
import com.funny.admin.condition.sys.UserCondition;
import com.funny.admin.dao.sys.DictMapper;
import com.funny.admin.domain.sys.Dict;
import com.funny.admin.domain.sys.User;
import com.funny.admin.service.sys.DictService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funny.admin.service.sys.UserService;

import java.util.List;

@Service
public class DictServiceImpl implements DictService {
    @Autowired
    private DictMapper dictMapper;

    @Override
    public void addDict(Dict dict) {
        dictMapper.insert(dict);
    }

    @Override
    public void updateDict(Dict dict) {
                dictMapper.updateByIdSelected(dict);
    }

    @Override
    public Dict getDictById(Long id) {
        return dictMapper.findById(id);
    }

    @Override
    public Dict getDictByDictId(Integer dictId) {
        return dictMapper.getDictByDictId(dictId);
    }

    @Override
    public PageInfo<Dict> getPageDictList(DictCondition condition) {

        PageHelper.startPage(condition.getPageNo(), condition.getPageSize());
        List<Dict> dicts = dictMapper.getPageDictList(condition);
        return new PageInfo<Dict>(dicts);
    }
}
