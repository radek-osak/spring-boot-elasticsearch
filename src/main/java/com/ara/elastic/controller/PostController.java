package com.ara.elastic.controller;

import com.ara.elastic.model.Post;
import com.ara.elastic.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@RequestBody Post post) {
        return postService.save(post);
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<Post> findAll(){
        return postService.findAll();
    }

    @RequestMapping(value = "phrase", method = RequestMethod.GET)
    public List<Post> findByPhrase(@RequestParam("phrase") String phrase){
        return postService.findAllByPhrase(phrase);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Post findById(@RequestParam("id") String id){
        return postService.findById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public void deleteById(@RequestParam("id") String id){
        postService.delete(id);
    }
}
