package com.example.demo.controller;

import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/viewer")
@PreAuthorize("hasRole('VIEWER')")
public class ViewerController {

    private final ArticleRepository articleRepo;

    public ViewerController(ArticleRepository articleRepo) {
        this.articleRepo = articleRepo;
    }

    @GetMapping("/dashboard")
    public String viewArticles(Model model) {
        List<Article> approvedArticles = articleRepo.findByApproved(true);
        model.addAttribute("articles", approvedArticles);
        return "viewerDashboard";
    }
}
