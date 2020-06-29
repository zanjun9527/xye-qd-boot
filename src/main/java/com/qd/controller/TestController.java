package com.qd.controller;


import com.alibaba.fastjson.JSONObject;
import com.qd.dmo.BaseCountryArea;
import com.qd.dmo.UserContact;
import com.qd.service.ISimpleInfoService;
import com.qd.service.IUserContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    IUserContactService userContactService;

    @Autowired
    ISimpleInfoService simpleInfoService;


    @RequestMapping("gogo")
    @ResponseBody
    public Object getUserContact(){
        List<UserContact> userContactList = userContactService.getUserContactList(1);
        System.out.println("好了");
        return userContactList;
    }


    @RequestMapping("testArea")
    @ResponseBody
    public Object testArea(){
        ModelAndView mv = new ModelAndView();
        System.out.println("好了");

        List<BaseCountryArea> areaLists = simpleInfoService.getAreaLists(null, 1017);

        return areaLists;
    }

    /**
     * 地址初始页面
     * @return
     */
    @RequestMapping("testArea2")
    public ModelAndView testArea2(){
        ModelAndView mv = new ModelAndView();


        List<BaseCountryArea> areaLists = simpleInfoService.getAreaLists(2, null);
        mv.addObject("areaList",areaLists);
        mv.setViewName("test");
        return mv;
    }


    /**
     * ajax选择返回地址
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("testArea3")
    @ResponseBody
    public Object testArea3(HttpServletRequest request, HttpServletResponse response){
        String levels = request.getParameter("level");
        String parentIds = request.getParameter("parentId");

        Integer level= levels==null? null: Integer.valueOf(levels);
        Integer parentId= parentIds==null? null: Integer.valueOf(parentIds);

        List<BaseCountryArea> areaLists = simpleInfoService.getAreaLists(level, parentId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("areaList",areaLists);
        return jsonObject;
    }



    @RequestMapping("test1")
    public ModelAndView testIndex(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("userName","zhangsan");
        mv.setViewName("test");
        return mv;
    }


    /**
     * 预约报名提交
     */
    @RequestMapping("/test/addUserContact")
    public void addUserContact(){

        //cell_phone
        //location
        //flag
        //date_insert

        UserContact userContactDto = new UserContact();
        userContactDto.setUserName("wangyun");
        userContactDto.setCellPhone("18862241316");
        userContactDto.setLocation(16);
        userContactDto.setFlag(0);
        userContactDto.setDateInsert(new Date());
        userContactService.addUserContact(userContactDto);
    }

    /**
     * 更新联系状态
     */
    @RequestMapping("/test/updateUserContact")
    public void updateUserContact(){

        String id="2";//联系方式id
        userContactService.updateUserContactStatus(Integer.valueOf(id),1);//从已联系更新为未联系
    }


}
