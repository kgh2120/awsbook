package com.example.awsbook.service;

import com.example.awsbook.controller.PostForm;
import com.example.awsbook.domain.Post;
import com.example.awsbook.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Slf4j
@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService{

    private final PostRepository repository;

    @Override
    public void createPost(Post post) {
        repository.save(post);
    }

    @Override
    public Post readOne(Long id) {

        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<Post> readAll() {
        return repository.findAll();
    }

    @Override
    public Long update(Long id, PostForm postForm) {
        Post finded = repository.findById(id).orElseThrow();
        finded.setAuthor(postForm.getAuthor());
        finded.setDescription(postForm.getDescription());


        return finded.getId();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
