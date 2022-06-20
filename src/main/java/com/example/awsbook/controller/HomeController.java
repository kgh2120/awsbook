package com.example.awsbook.controller;

import com.example.awsbook.config.SessionUser;
import com.example.awsbook.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;


@RequiredArgsConstructor
@Controller
public class HomeController {
    private final PostService postService;
    private final HttpSession httpSession;
    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("posts",postService.readAll());

        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            model.addAttribute("uesrName", user.getName());
        }else
            model.addAttribute("uesrName", "Guest");

        return "index";
    }
}
