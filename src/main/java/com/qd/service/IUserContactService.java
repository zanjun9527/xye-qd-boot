package com.qd.service;

import com.qd.dmo.UserContact;

import java.util.List;

public interface IUserContactService {

    /**
     * 根据状态查询用户的联系方式
     * @param status
     * @return
     */
    List<UserContact> getUserContactList(Integer status);


    void addUserContact(UserContact UserContac);

    /**
     * 更新用户联系方式的状态
     * @param status
     * @param id
     */
    void updateUserContactStatus(Integer id,Integer status);


}
