package com.example.demo.controller;

import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reviewer")
@PreAuthorize("hasRole('REVIEWER')")
public class ReviewerController {
    private final ArticleRepository articleRepo;

    public ReviewerController(ArticleRepository articleRepo) {
        this.articleRepo = articleRepo;
    }

    @GetMapping("/dashboard")
    public String reviewerDashboard(Model model) {
        List<Article> pending = articleRepo.findByApprovedFalse();
        model.addAttribute("articles", pending);
        return "reviewerDashboard";
    }

    @PostMapping("/approve/{id}")
    public String approve(@PathVariable Long id) {
        Article a = articleRepo.findById(id).get();
        a.setApproved(true);
        articleRepo.save(a);
        return "redirect:/reviewer/dashboard";
    }
}
