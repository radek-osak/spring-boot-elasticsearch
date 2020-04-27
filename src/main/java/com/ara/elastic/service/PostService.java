package com.ara.elastic.service;

import com.ara.elastic.model.Post;

import java.util.List;

public interface PostService {

    String save(Post post);
    void delete(String postId);

    Post findById(String postId);
    List<Post> findAll();
    List<Post> findAllByPhrase(String phrase);
}
