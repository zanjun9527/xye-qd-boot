package com.qd.dao;

import com.qd.dmo.UserContact;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserContactMapper extends BaseMapper<UserContact>{


    /**
     * 查询待联系客户
     * @return
     */
    List<UserContact> getContactListByFlag(@Param("status") Integer status);



    int updateUserContractStatus(@Param("id") Integer id,@Param("status") Integer status);

}