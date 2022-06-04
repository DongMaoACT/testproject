package com.eric.controller;

import com.eric.pojo.User;
import com.eric.pojo.UserResult;
import com.eric.service.UserSignService;
import com.eric.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private UserSignService userSignService;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public UserResult validateUser(@RequestBody User Ui) {
        UserResult result  = new UserResult();
        String em = Ui.getEmail();
        User user = userService.LoginUser(em, Ui.getPassword());

        System.out.println(user);
        if (user != null) {
            result.setUser(user);
            result.setStatus(1);
        }else {
            result.setStatus(0);
        }
        return result;
    }
    @RequestMapping("/register")
    public String regist(){
        return "/register";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String doRegist(User user, Model model){
        System.out.println(user.getId());
        userService.Regist(user);
        return "success";
    }

    /**
     * 额外需求： 签到提高用户积分
     * @param userid
     * @return
     */
    @RequestMapping("/{userid}/sign")
    public int doSign(@PathVariable("userid")int userid){
        int totalNum = userSignService.updateSign(userid);
        return totalNum;
    }
}
