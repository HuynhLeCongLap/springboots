package com.entity.demo_springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.demo_springboot.entity.User;
import com.entity.demo_springboot.service.FollowService;
import com.entity.demo_springboot.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;  // Inject service để lấy danh sách người dùng

    @GetMapping("/users")
    public String userList(Model model) {
        List<User> users = userService.getAllUsers(); // Lấy danh sách người dùng từ database
        model.addAttribute("users", users);
        return "admin/user_list";  // Trả về view user_list.html
    }
}