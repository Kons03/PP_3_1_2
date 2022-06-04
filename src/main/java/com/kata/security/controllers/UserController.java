package com.kata.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.kata.security.model.User;
import com.kata.security.service.UserService;

import java.security.Principal;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String toUser(Principal principal, Model model) {
        User user = (User) userService.loadUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "user";
    }

}
