package com.kuang.controller;

import com.kuang.serviceimpl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloWorld
 * @Description TODO
 * @Author ht
 * @Date 2020/8/12 16:45
 * @Version 1.0
 **/

@Controller
public  class HelloController{
  @Autowired
  UserDetailsServiceImpl userDetailsService;

  @GetMapping("/user")
  public String success(String name){
//    userDetailsService.loadUserByUsername(name);
    return "success";
  }

  @GetMapping("/root")
  public String vip(String name){
//    userDetailsService.loadUserByUsername(name);
    return "vip";
  }

  @GetMapping("/not")
  public String not(String name) {
    userDetailsService.loadUserByUsername(name);
    return "not";
  }

}
