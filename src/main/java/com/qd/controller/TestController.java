package com.qd.controller;


import com.alibaba.fastjson.JSONObject;
import com.qd.dmo.UserContact;
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



    @RequestMapping("gogo")
    @ResponseBody
    public Object getUserContact(){


        List<UserContact> userContactList = userContactService.getUserContactList(1);

        System.out.println("好了");

        return userContactList;
    }



    @RequestMapping("test1")
    public ModelAndView testIndex(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("userName","zhangsan");
        mv.setViewName("test");

        return mv;
    }


}
