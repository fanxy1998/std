package com.fanxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * @author fanxy
 */
@Controller
public class ViewController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/index/{username}")
    public String index(HttpServletRequest request, @PathVariable("username") String username){

        String loginUserName = "loginUserName";
        if (username!=null && request.getSession().getAttribute(loginUserName).equals(username)){
            return "frame";
        }
        return null;
    }

    @GetMapping("/addUser")
    public String addUser(){ return "addUser"; }

    @GetMapping("/updateUser")
    public String updateUser(){
        return "updateUser";
    }

    @GetMapping("/cgPassword")
    public String cgPassword(){
        return "cgPassword";
    }

    @GetMapping("/userList")
    public String userList(){
        return "userList";
    }

    @GetMapping("/sign")
    public String sign(){ return "sign"; }

    @GetMapping("/emSalary")
    public String emSalary(){ return "emSalary"; }


}
