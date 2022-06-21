package com.example.awsbook.service;

import com.example.awsbook.domain.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class PostServiceImplTest {

    @Autowired
    PostService postService;

    @Test
    void createPost() {
        Post post = Post.builder()
                .author("테스터")
                .description("내용").build();

        postService.createPost(post);

        Post find = postService.readOne(post.getId());

        assertThat(post).isEqualTo(find);
    }

    @Test
    void readOne_Exception() {


        assertThatThrownBy(() -> postService.readOne(999L))
                .isInstanceOf(NoSuchElementException.class);


    }


}