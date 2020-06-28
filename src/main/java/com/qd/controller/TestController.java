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

        List<BaseCountryArea> areaLists = simpleInfoService.getAreaLists(2, null);

        return areaLists;
    }






    @RequestMapping("test1")
    public ModelAndView testIndex(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("userName","zhangsan");
        mv.setViewName("test");
        return mv;
    }


}
