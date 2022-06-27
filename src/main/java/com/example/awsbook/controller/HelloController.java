package com.example.awsbook.controller;


import com.example.awsbook.config.LoginUser;
import com.example.awsbook.config.SessionUser;
import com.example.awsbook.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("hello")
@Controller
public class HelloController {
    private final PostService postService;
    private final HttpSession httpSession;

    @ResponseBody
    @GetMapping("/korea")
    public ResponseEntity<String> helloKorea() {
        String korea = "hello~ korea";
        return ResponseEntity.ok(korea);
    }
    @ResponseBody
    @GetMapping("/japan")
    public ResponseEntity<String> helloJapan() {
        String japan = "hello~ japan";
        return ResponseEntity.ok(japan);
    }

    @GetMapping("/leaf")
    public String helloLeaf() {
        return "helloLeaf";
    }



    @GetMapping("/haha")
    public String home(Model model, @LoginUser SessionUser user) {

        model.addAttribute("posts",postService.readAll());


        log.info("helloController - user = {}",user);
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }else
            model.addAttribute("userName", "Guest");

        return "index";
    }


}
