package com.ara.elastic.controller;

import com.ara.elastic.model.Post;
import com.ara.elastic.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@RequestBody Post post) {
        return postService.save(post);
    }
}
