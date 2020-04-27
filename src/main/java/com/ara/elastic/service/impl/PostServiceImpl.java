package com.ara.elastic.service.impl;

import com.ara.elastic.model.Post;
import com.ara.elastic.repository.PostRepository;
import com.ara.elastic.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public String save(Post post) {
        assignId(post);
        postRepository.save(post);
        return post.getId();
    }

    @Override
    public void delete(String postId) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent())
            postRepository.delete(post.get());
    }

    @Override
    public Post findById(String postId) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent())
            return post.get();
        return null;
    }

    @Override
    public List<Post> findAll() {
        return (List<Post>) postRepository.findAll();
    }

    @Override
    public List<Post> findAllByPhrase(String phrase) {
        return null;
    }

    private void assignId(Post post) {
        if (post.getId() == null)
            post.setId(UUID.randomUUID().toString());
    }
}
