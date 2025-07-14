package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

//    @GetMapping("/")
//    public String home() {
//        return "redirect:/login"; // Ensures clean redirection to login
//    }

	@GetMapping("/dashboard")
	public String dashboard(Authentication auth) {
	    String roles = auth.getAuthorities().toString();

	    if (roles.contains("ADMIN")) {
	        return "adminDashboard";
	    } else if (roles.contains("EDITOR")) {  // 🔼 Editor before Contributor
	        return "editorDashboard";
	    } else if (roles.contains("REVIEWER")) {
	        return "reviewerDashboard";
	    } else if (roles.contains("CONTRIBUTOR")) {
	        return "contributorDashboard";
	    } else if (roles.contains("VIEWER")) {
	        return "viewerDashboard";
	    }

	    return "login";
	}

}
