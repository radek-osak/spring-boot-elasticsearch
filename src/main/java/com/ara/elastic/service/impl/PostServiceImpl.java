package com.ara.elastic.service.impl;

import com.ara.elastic.model.Post;
import com.ara.elastic.repository.PostRepository;
import com.ara.elastic.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.elasticsearch.index.query.QueryBuilders.regexpQuery;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Override
    public String save(Post post) {
        assignId(post);
        postRepository.save(post);
        return post.getId();
    }

    @Override
    public void delete(String postId) {
        Optional<Post> post = postRepository.findById(postId);
        post.ifPresent(post1 -> postRepository.delete(post1));
    }

    @Override
    public Post findById(String postId) {
        Optional<Post> post = postRepository.findById(postId);
        return post.orElse(null);
    }

    @Override
    public List<Post> findAll() {
        return ((PageImpl)postRepository.findAll()).getContent();
    }

    @Override
    public List<Post> findAllByPhrase(String phrase) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withFilter(regexpQuery("content", ".*" + phrase + ".*"))
                .build();
        return esTemplate.queryForList(searchQuery, Post.class);
    }

    private void assignId(Post post) {
        if (post.getId() == null)
            post.setId(UUID.randomUUID().toString());
    }
}
