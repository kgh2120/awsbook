package com.example.awsbook.controller;


import com.example.awsbook.domain.Post;
import com.example.awsbook.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/post")
public class PostController {

    private final PostService postService;


    @GetMapping("/add")
    public String createPostForm(@ModelAttribute PostForm post) {

        return "post/createMemberForm";
    }
    @PostMapping("/add")
    public String createPost(@RequestBody PostForm postForm) {
        Post post = Post.builder().author(postForm.getAuthor())
                        .description(postForm.getDescription()).build();
        postService.createPost(post);

        return "redirect:/";
    }
}
