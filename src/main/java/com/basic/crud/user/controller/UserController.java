package com.basic.crud.user.controller;

import com.basic.crud.user.entity.User;
import com.basic.crud.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/users")
    public String userList(Model model) {
        model.addAttribute("userList", service.userList());
        return "user-list";
    }

    @GetMapping("/users/new")
    public String addUserForm() {
        return "user-add";
    }

    @PostMapping("/users/new")
    public String addUser(@ModelAttribute User user) {
        service.addUser(user);
        return "redirect:/";
    }
}
