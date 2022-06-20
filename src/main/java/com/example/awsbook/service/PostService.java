package com.example.awsbook.service;

import com.example.awsbook.domain.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    void createPost(Post post);

    Post readOne(Long id);

    List<Post> readAll();

    Long update(Post post);

    void delete(Long id);

}
