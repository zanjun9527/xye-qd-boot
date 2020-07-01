package com.qd.dao;

import com.qd.dmo.AdminUser;
import org.apache.ibatis.annotations.Param;

public interface AdminUserMapper extends BaseMapper<AdminUser>{


    AdminUser selectUserByCellPhone(@Param("cellPhone") String cellPhone);


}