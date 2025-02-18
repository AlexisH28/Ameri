package com.c3.Ameri.controller;

import com.c3.Ameri.dto.Request.CreatePostRequest;
import com.c3.Ameri.dto.Request.UpdatePostRequest;
import com.c3.Ameri.dto.Response.PostResponse;
import com.c3.Ameri.entity.Post;
import com.c3.Ameri.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public ResponseEntity<String> createPost(Authentication authentication,
                                             @RequestBody @Valid CreatePostRequest request) {
        String username = authentication.getName();
        String result = postService.createPost(username, request);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{postId}")
    public ResponseEntity<String> updatePost(Authentication authentication,
                                             @PathVariable Long postId,
                                             @RequestBody @Valid UpdatePostRequest request) {
        String username = authentication.getName();
        String result = postService.updatePost(postId, username, request);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<String> deletePost(Authentication authentication,
                                             @PathVariable Long postId) {
        String username = authentication.getName();
        String result = postService.deletePost(postId, username);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/sorted")
    public ResponseEntity<Page<PostResponse>> getPostsSortedByDate(
            @RequestParam(defaultValue = "desc") String order,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<PostResponse> posts = postService.getPostsSortedByDate(order, page, size);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<PostResponse>> getAllPosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<PostResponse> posts = postService.getAllPosts(page, size);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable Long postId) {
        Post post = postService.getPostById(postId);
        return ResponseEntity.ok(post);
    }
}
