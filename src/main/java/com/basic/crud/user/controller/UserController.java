package com.basic.crud.user.controller;

import com.basic.crud.user.entity.User;
import com.basic.crud.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/users/{id}")
    public String userInfo(@PathVariable Integer id, Model model) {
        User user = service.getUserById(id);
        model.addAttribute("user", user);
        return "user-info";
    }

    @PatchMapping("/users/{id}")
    public String userUpdate(@PathVariable Integer id, @ModelAttribute User user) {
        User originUser = service.getUserById(id);
        originUser.update(user.getName(), user.getAge());
        service.updateUser(originUser);
        return "redirect:/users";
    }

    @DeleteMapping("/users/{id}")
    public String userDelete(@PathVariable Integer id) {
        User user = service.getUserById(id);
        service.deleteUser(user);
        return "redirect:/users";
    }
}
