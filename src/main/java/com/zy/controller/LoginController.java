package com.zy.controller;

import com.zy.utils.ActivierUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author: 张勇
 * @Blog: https://blog.csdn.net/zy13765287861
 * @Version: 1.0
 * @Date: 2020-11-05 14:10
 * @PS: 用户登录控制器
 */
@Controller
@RequestMapping("login")
public class LoginController {

    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 做登录
     *
     * @param username
     * @param pwd
     * @param session
     * @return
     */
    @RequestMapping("login")
    public String login(String username, String pwd, HttpSession session) {

        //得到主体
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, pwd);

        try {
            subject.login(token);
            System.out.println("登录成功");
            ActivierUser activierUser = (ActivierUser) subject.getPrincipal();
            session.setAttribute("user", activierUser.getUser());
            return "redirect:/user/toUserManager.action";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "redirect:/index.jsp";
        }
    }

}
