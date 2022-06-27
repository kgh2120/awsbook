package com.example.awsbook.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("hello")
@RestController
public class HelloController {


    @GetMapping("/korea")
    public ResponseEntity<String> helloKorea() {
        String korea = "hello~ korea";
        return ResponseEntity.ok(korea);
    }

    @GetMapping("/japan")
    public ResponseEntity<String> helloJapan() {
        String japan = "hello~ japan";
        return ResponseEntity.ok(japan);
    }
}
