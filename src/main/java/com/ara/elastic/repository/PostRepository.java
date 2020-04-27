package com.ara.elastic.repository;

import com.ara.elastic.model.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PostRepository extends ElasticsearchRepository<Post, String> {
}
