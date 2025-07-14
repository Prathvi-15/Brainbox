package com.example.demo.controller;

import com.example.demo.model.Article;
import com.example.demo.model.User;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
@PreAuthorize("hasRole('CONTRIBUTOR')")
public class ContributorController {
    private final UserRepository userRepo;
    private final ArticleRepository articleRepo;

    public ContributorController(UserRepository userRepo, ArticleRepository articleRepo) {
        this.userRepo = userRepo;
        this.articleRepo = articleRepo;
    }

    @GetMapping("/contributor/dashboard")
    public String contributorDashboard(Model model, Principal principal) {
        User user = userRepo.findByUsername(principal.getName()).get();
        List<Article> articles = articleRepo.findByAuthor(user);
        model.addAttribute("articles", articles);
        return "contributorDashboard";
    }
}
