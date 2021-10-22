package com.example.springsecurity.controller;

import com.example.springsecurity.entity.User;
import com.example.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/reg")
    public ModelAndView registration(@ModelAttribute("newUser") User user, ModelAndView modelAndView){
        modelAndView.setViewName("reg");
        return modelAndView;
    }

    @PostMapping("/reg")
    public ModelAndView modelAndView(@ModelAttribute("newUser") User user, ModelAndView modelAndView){
        modelAndView.setViewName("reg");
        if(userService.addUser(user)){
            modelAndView.addObject("message", "User successfully added");
        }else modelAndView.addObject("message", "It's user has already existed");
        return modelAndView;
    }


    @GetMapping("/auth")
    public ModelAndView authorization(ModelAndView modelAndView){
        modelAndView.setViewName("auth");
        return modelAndView;
    }

}
