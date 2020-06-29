package com.qd.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qd.dao.UserContactMapper;
import com.qd.dmo.UserContact;
import com.qd.service.IUserContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userContactService")
public class UserContactServiceImpl implements IUserContactService {

    private final static Logger logger = LoggerFactory.getLogger(UserContactServiceImpl.class);


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

    @Override
    public void addUserContact(UserContact userContac) {

        int i = userContactMapper.insertSelective(userContac);

        if(i>0){
            logger.info("添加用户联系方式成功,用户：{}",userContac.getCellPhone());
        }else{
            logger.error("添加用户联系方式成功,用户：{}",userContac.getCellPhone());
        }
    }

    @Override
    public void updateUserContactStatus(Integer id,Integer status) {

        int i = userContactMapper.updateUserContractStatus(id, status);

        if(i>0){
            logger.info("更新联系状态成功,联系id：{}",id);
        }else{
            logger.error("更新联系状态失败,联系id：{}",id);
        }
    }
}
