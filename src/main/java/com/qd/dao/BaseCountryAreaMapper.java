package com.qd.dao;

import com.qd.dmo.BaseCountryArea;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseCountryAreaMapper extends BaseMapper<BaseCountryArea>{



    List<BaseCountryArea> getAreaLists(@Param("arealevel") Integer level, @Param("parenId")Integer parentId);

}