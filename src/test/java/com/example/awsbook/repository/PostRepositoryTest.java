package com.example.awsbook.repository;

import com.example.awsbook.domain.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class PostRepositoryTest {

    @Autowired
    PostRepository repository;

    @BeforeEach
    void beforeEach() {
        for (int i = 0; i < 10; i++) {
            Post post = Post.builder()
                    .author("테스터"+i)
                    .description("내용"+i).build();
            repository.save(post);
        }
    }
    @AfterEach
    void afterEach() {
        repository.deleteAll();
    }

    @Test
    void createAndReadOne() {
        Post post = Post.builder()
                        .author("테스터1")
                                .description("내용1").build();
        repository.save(post);

        Post finded = repository.findById(post.getId()).get();

        assertThat(post).isEqualTo(finded);
    }

    @Test
    void findAll() {
        List<Post> all = repository.findAll();
        assertThat(all.size()).isSameAs(10);
    }

}