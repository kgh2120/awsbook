package com.example.awsbook.controller;


import com.example.awsbook.domain.Post;
import com.example.awsbook.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/post")
public class PostController {

    private final PostService postService;


    @GetMapping("/add")
    public String createPostForm(@ModelAttribute PostForm post) {

        return "post/createPostForm";
    }

    @ResponseBody
    @PostMapping("/add")
    public ResponseEntity<Post> createPost(@RequestBody PostForm postForm) {
        log.info("post author {} , desc = {}", postForm.getAuthor(), postForm.getDescription());
        Post post = Post.builder().author(postForm.getAuthor())
                        .description(postForm.getDescription()).build();
        postService.createPost(post);

        URI location = UriComponentsBuilder.fromUriString("localhost:8080/post")
                .path("/{id}")
                .buildAndExpand(post.getId())
                .toUri();


        return ResponseEntity.created(location).body(post);
    }

    @GetMapping("/{id}")
    public String updatePostForm(@PathVariable Long id, Model model) {
        Post post = postService.readOne(id);
        model.addAttribute("post", post);
        return "post/updatePostForm";
    }

    @ResponseBody
    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody PostForm postForm) {

        postService.update(id, postForm);

        return ResponseEntity.ok().body(postService.readOne(id));
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.delete(id);
    }

}
