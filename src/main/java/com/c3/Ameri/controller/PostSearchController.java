package com.c3.Ameri.controller;

import com.c3.Ameri.entity.Post;
import com.c3.Ameri.service.PostSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostSearchController {

    @Autowired
    private PostSearchService postSearchService;

    @GetMapping("/search")
    public Page<Post> searchPosts(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return postSearchService.searchPosts(keyword, PageRequest.of(page, size));
    }

    @GetMapping("/filter/date")
    public Page<Post> filterPostsByDate(
            @RequestParam String order,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return postSearchService.filterPostsByDate(order, PageRequest.of(page, size));
    }
}
