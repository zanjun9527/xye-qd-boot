package com.qd.controller;


import com.qd.dmo.UserContact;
import com.qd.service.IUserContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    IUserContactService userContactService;



    @RequestMapping("gogo")
    public void getUserContact(){


        List<UserContact> userContactList = userContactService.getUserContactList(0);


        System.out.println("好了");

    }


}
