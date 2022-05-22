package com.eric.controller;

import com.eric.pojo.User;
import com.eric.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserServiceImpl userService;

    @RequestMapping(value = "/validateUser", method = RequestMethod.POST)
    public ModelAndView validateUser(@RequestParam("id") String id, @RequestParam("password") String password) {
        ModelAndView mv = new ModelAndView();
        User user = userService.validateUser(id, password);
        if (user != null) {
            mv.addObject("user", user);
            mv.setViewName("success");
        }else {
            mv.setViewName("fail");
        }
        return mv;
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
}
