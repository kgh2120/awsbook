package com.example.awsbook.controller;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("hello")
@Controller
public class HelloController {


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


}
