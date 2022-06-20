package com.example.awsbook.controller;

import com.example.awsbook.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@RequiredArgsConstructor
@Controller
public class HomeController {
    private final PostService postService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("posts",postService.readAll());

        return "index";
    }
}
