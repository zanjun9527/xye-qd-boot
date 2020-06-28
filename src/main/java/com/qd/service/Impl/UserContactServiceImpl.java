package com.qd.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qd.dao.UserContactMapper;
import com.qd.dmo.UserContact;
import com.qd.service.IUserContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userContactService")
public class UserContactServiceImpl implements IUserContactService {

    @Autowired
    UserContactMapper userContactMapper;

    @Override
    public List<UserContact> getUserContactList(Integer status) {


//        PageHelper.startPage(1,3);  分页信息

          List<UserContact> contactListByFlag = userContactMapper.getContactListByFlag(status);

//       PageInfo gitPageInfo=new PageInfo<UserContact>(contactListByFlag);//分页信息

        System.out.println(JSONObject.toJSONString(contactListByFlag));
        return contactListByFlag;
    }
}
