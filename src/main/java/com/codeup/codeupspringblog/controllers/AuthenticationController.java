package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.security.AuthBuddy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        User loggedInUser = AuthBuddy.getLoggedInUser();
        model.addAttribute("loggedInUser", loggedInUser);

        return "users/login";
    }
}



