package com.qd.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.qd.dao.AdminUserMapper;
import com.qd.dao.BaseCountryAreaMapper;
import com.qd.dmo.AdminUser;
import com.qd.dmo.BaseCountryArea;
import com.qd.service.ISimpleInfoService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("simpleInfoService")
public class SimpleInfoServiceImpl implements ISimpleInfoService {

    private final static Logger logger = LoggerFactory.getLogger(UserContactServiceImpl.class);

    @Autowired
    BaseCountryAreaMapper  baseCountryAreaMapper;

    @Autowired
    AdminUserMapper adminUserMapper;


    @Override
    public List<BaseCountryArea> getAreaLists(Integer level, Integer parentId) {

        List<BaseCountryArea> areaLists = baseCountryAreaMapper.getAreaLists(level, parentId);

        return areaLists;
    }

    @Override
    public Boolean doAdminUser(String cellPhone, String passWord) {
        AdminUser adminUser = adminUserMapper.selectUserByCellPhone(cellPhone);
        if(adminUser==null){
            //添加用户
            return  false;
        }else{
            //更新密码
            AdminUser adUser = new AdminUser();
            adUser.setId(adminUser.getId());
            adUser.setPassWord(getPassWord(passWord));
            int i = adminUserMapper.updateByIdSelective(adUser);
            if(i>0){
                return  true;
            }
        }



        return false;
    }



    @Override
    public JSONObject adminLogin(String cellPhone, String passWord) {
        JSONObject jsonObject = new JSONObject();

        AdminUser adminUser = adminUserMapper.selectUserByCellPhone(cellPhone);
        if(adminUser==null){
            //添加用户
            jsonObject.put("code","0");
            jsonObject.put("msg","用户不存在");

        }else{
            String md5Code = getPassWord(passWord);
            if(!md5Code.equals(adminUser.getPassWord())){
                jsonObject.put("code","0");
                jsonObject.put("msg","密码不正确");
            }else{
                jsonObject.put("code","1");
                jsonObject.put("msg","登录成功");
                logger.info("用户：{}，登录成功",cellPhone);
            }
        }

        return jsonObject;
    }



    public String getPassWord(String passWord) {
        String sk = DigestUtils.md5Hex(passWord + "abc123");
        return sk;
    }


}
