package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/dashboard")
    public String home(Authentication auth) {
        String roles = auth.getAuthorities().toString();

        if (roles.contains("ROLE_ADMIN")) return "redirect:/admin/dashboard";
        if (roles.contains("ROLE_CONTRIBUTOR")) return "redirect:/contributor/dashboard";
        if (roles.contains("ROLE_REVIEWER")) return "redirect:/reviewer/dashboard";
        if (roles.contains("ROLE_VIEWER")) return "redirect:/viewer/dashboard";
        if (roles.contains("ROLE_EDITOR")) return "redirect:/editor/dashboard";

        return "redirect:/login";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }
}
