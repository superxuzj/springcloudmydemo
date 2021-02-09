package com.bjsxt.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xuzhijian
 * @date 2021/2/9
 **/
@Controller
public class IndexController {

    @RequestMapping("login")
    public String login() {
        System.out.println("login");
        return "login";
    }

    @PostMapping("userLogin")
    public String userLogin(String uname, String pwd) {
        System.out.println("userLogin");
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(uname, pwd));
            return "main";
        } catch (AuthenticationException e) {
            System.out.println("失败");
            return "login";
        }
    }
}
