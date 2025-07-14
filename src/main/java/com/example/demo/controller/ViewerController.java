package com.example.demo.controller;

import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewerController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/viewer/dashboard")
    public String viewerDashboard(Model model) {
        // Only show approved articles to viewer
        List<Article> approvedArticles = articleRepository.findAll()
                .stream()
                .filter(Article::isApproved)
                .toList();

        model.addAttribute("articles", approvedArticles);
        return "viewerDashboard";
    }
}
