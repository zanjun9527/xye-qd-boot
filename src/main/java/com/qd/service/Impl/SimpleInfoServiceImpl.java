package com.qd.service.Impl;

import com.qd.dao.BaseCountryAreaMapper;
import com.qd.dmo.BaseCountryArea;
import com.qd.service.ISimpleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("simpleInfoService")
public class SimpleInfoServiceImpl implements ISimpleInfoService {

    @Autowired
    BaseCountryAreaMapper  baseCountryAreaMapper;



    @Override
    public List<BaseCountryArea> getAreaLists(Integer level, Integer parentId) {

        List<BaseCountryArea> areaLists = baseCountryAreaMapper.getAreaLists(level, parentId);

        return areaLists;
    }
}
