package com.c3.Ameri.service;

import com.c3.Ameri.entity.Post;
import com.c3.Ameri.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PostSearchService {

    private final PostRepository postRepository;

    public PostSearchService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Page<Post> searchPosts(String order, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, getSortOrder(order, "createdAt"));
        return postRepository.findAll(pageable);
    }

    public Page<Post> getPostPage(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public Page<Post> findPostsByDate(String order, Pageable pageable) {
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), getSortOrder(order, "createdAt"));
        return postRepository.findAll(sortedPageable);
    }

    private Sort getSortOrder(String order, String field) {
        return "asc".equalsIgnoreCase(order) ? Sort.by(field).ascending() : Sort.by(field).descending();
    }

    public Page<Post> filterPostsByDate(String order, PageRequest of) {
        return null;
    }

    public Page<Post> searchPosts(String keyword, PageRequest of) {
        return null;
    }
}
