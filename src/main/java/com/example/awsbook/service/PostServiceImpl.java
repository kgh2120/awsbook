package com.example.awsbook.service;

import com.example.awsbook.domain.Post;
import com.example.awsbook.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Long update(Post post) {
        Post finded = repository.findById(post.getId()).orElseThrow();
        finded.setAuthor(post.getAuthor());
        finded.setDescription(post.getDescription());
        return finded.getId();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
