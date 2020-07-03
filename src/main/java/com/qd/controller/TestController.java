package com.qd.controller;


import com.alibaba.fastjson.JSONObject;
import com.qd.dmo.BaseCountryArea;
import com.qd.dmo.UserContact;
import com.qd.service.ISimpleInfoService;
import com.qd.service.IUserContactService;
import com.qd.service.Impl.UserContactServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(UserContactServiceImpl.class);

    @Autowired
    IUserContactService userContactService;

    @Autowired
    ISimpleInfoService simpleInfoService;


    /**
     * @return
     */
    @RequestMapping("index")
    @ResponseBody
    public Object index(){

        return "";
    }

    /**
     * @return
     */
    @RequestMapping("/admin/say")
    public void adminSay(){
        System.out.println("admin  say lalala");
    }




    @RequestMapping("gogo")
    @ResponseBody
    public Object getUserContact(){
        List<UserContact> userContactList = userContactService.getUserContactList(1);
        System.out.println("好了");
        return userContactList;
    }


    /**
     * 地址初始页面,初始化获取省，然后依次选择市、区
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
     * ajax选择返回地址，依次选择市、区
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




    /**
     * 预约报名提交,保存客户预约报名的信息
     */
    @RequestMapping("/test/addUserContact")
    public void addUserContact(){
        //cell_phone    location    flag    date_insert
        UserContact userContactDto = new UserContact();
        userContactDto.setUserName("wangyun");
        userContactDto.setCellPhone("18862241316");
        userContactDto.setLocation(16);
        userContactDto.setFlag(0);
        userContactDto.setDateInsert(new Date());
        userContactService.addUserContact(userContactDto);
    }

    /**
     * 更新联系状态，变更联系状态
     */
    @RequestMapping("/test/updateUserContact")
    public void updateUserContact(){

        String id="2";//联系方式id
        userContactService.updateUserContactStatus(Integer.valueOf(id),1);//从已联系更新为未联系
    }


    /**
     * 测试登录功能
     */
    @RequestMapping("/test/login")
    @ResponseBody
    public JSONObject login(HttpServletRequest request, HttpServletResponse response){
        String cellPhone = request.getParameter("cellPhone");
        String passWord = request.getParameter("passWord");
        JSONObject jsonObject = new JSONObject();

        jsonObject = simpleInfoService.adminLogin(cellPhone, passWord);

        if(jsonObject!=null && "1".equals(jsonObject.getString("code"))){
            request.getSession().setAttribute("loginFlag","1");//session放入登录标记
        }

        return jsonObject;
    }


    /**
     * 测试session过期时间
     */
    @RequestMapping("/test/session")
    @ResponseBody
    public JSONObject testSession(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        Object loginFlag = request.getSession().getAttribute("loginFlag");
        int interval = request.getSession().getMaxInactiveInterval();
        System.out.println("session过期时间(s):" + interval);
        System.out.println(loginFlag.toString());
        return jsonObject;
    }

    /**
     * 跳转登录页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/test/loginPage")
    public ModelAndView teslogin(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("testLogin");
        return mv;
    }





    /**
     *
     * 更新用户密码，目前简单设置
     * @param request
     * @param response
     */
    @RequestMapping("/test/doAdminUser")
    @ResponseBody
    public Object doAdminUser(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        String cellPhone = request.getParameter("cellPhone");
        String passWord = request.getParameter("passWord");
        String key = request.getParameter("superKey");
        if(StringUtils.isEmpty(cellPhone) || StringUtils.isEmpty(passWord) || StringUtils.isEmpty(key)){
            logger.error("参数缺失");
            jsonObject.put("code","0");
            jsonObject.put("msg","参数缺失");
            return jsonObject;
        }
        if(!"qiangding123456".equals(key)){
            logger.error("超级密码不正确");
            jsonObject.put("code","0");
            jsonObject.put("msg","超级密码不正确");
            return jsonObject;
        }
        Boolean aBoolean = simpleInfoService.doAdminUser(cellPhone, passWord);

        if(aBoolean){
            jsonObject.put("code","1");
            jsonObject.put("msg","更新密码成功");
            return jsonObject;
        }else{
            jsonObject.put("code","1");
            jsonObject.put("msg","更新密码失败");
            return jsonObject;
        }
    }


//    public static void main(String[] args) {
//        String sk = DigestUtils.md5Hex("123123" + "abc123");
//        System.out.println(sk);
//    }


}
