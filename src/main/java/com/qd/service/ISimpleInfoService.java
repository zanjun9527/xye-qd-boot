package com.qd.service;

import com.qd.dmo.BaseCountryArea;

import java.util.List;

public interface ISimpleInfoService {


    /**
     * 根据等级和parentid选择地址
     * @param level
     * @param parentId
     * @return
     */
    List<BaseCountryArea> getAreaLists(Integer level, Integer parentId);


}
