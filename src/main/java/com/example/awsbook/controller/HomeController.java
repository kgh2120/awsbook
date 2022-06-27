package com.example.awsbook.controller;

import com.example.awsbook.config.LoginUser;
import com.example.awsbook.config.SessionUser;
import com.example.awsbook.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {
    private final PostService postService;
    private final HttpSession httpSession;


    @GetMapping("")
    public String home(Model model,@LoginUser SessionUser user) {

        model.addAttribute("posts",postService.readAll());


        log.info("user = {}",user);
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }else
            model.addAttribute("userName", "Guest");

        return "index";
    }
}
