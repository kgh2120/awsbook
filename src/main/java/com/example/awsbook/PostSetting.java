package com.example.awsbook;


import com.example.awsbook.domain.Post;
import com.example.awsbook.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Configuration
public class PostSetting {

    private final PostRepository repository;

    @PostConstruct
    void init() {
        for (int i = 0; i < 10; i++) {
            Post post = Post.builder()
                    .author("테스터"+i)
                    .description("내용"+i).build();
            repository.save(post);
        }
    }
}
