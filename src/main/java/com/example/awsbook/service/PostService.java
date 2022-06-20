package com.example.awsbook.service;

import com.example.awsbook.controller.PostForm;
import com.example.awsbook.domain.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    void createPost(Post post);

    Post readOne(Long id);

    List<Post> readAll();

    Long update(Long id, PostForm postForm);

    void delete(Long id);

}
