package com.c3.Ameri.service;

import com.c3.Ameri.dto.Request.CreatePostRequest;
import com.c3.Ameri.dto.Request.UpdatePostRequest;
import com.c3.Ameri.dto.Response.PostResponse;
import com.c3.Ameri.entity.Post;
import com.c3.Ameri.entity.User;
import com.c3.Ameri.repository.PostRepository;
import com.c3.Ameri.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public String createPost(String username, CreatePostRequest request) {
        User author = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found."));

        Post post = new Post();
        post.setText(request.getText());
        post.setImageUrl(request.getImageUrl());
        post.setTags(request.getTags());
        post.setAuthor(author);
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());

        postRepository.save(post);

        return "Post created successfully.";
    }

    public String updatePost(Long postId, String username, UpdatePostRequest request) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found."));

        if (!post.getAuthor().getUsername().equals(username)) {
            throw new RuntimeException("You are not authorized to edit this post.");
        }

        post.setText(request.getText());
        post.setImageUrl(request.getImageUrl());
        post.setTags(request.getTags());
        post.setUpdatedAt(LocalDateTime.now());

        postRepository.save(post);

        return "Post updated successfully.";
    }

    public String deletePost(Long postId, String username) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found."));

        if (!post.getAuthor().getUsername().equals(username)) {
            throw new RuntimeException("You are not authorized to delete this post.");
        }

        postRepository.delete(post);

        return "Post deleted successfully.";
    }

    public Page<PostResponse> getPostsSortedByDate(String order, int page, int size) {
        PostSearchService postSearchService = null;
        return postSearchService.searchPosts(order, page, size)
                .map(this::convertToPostResponse);
    }

    private PostResponse convertToPostResponse(Post post) {
        PostResponse response = new PostResponse();
        response.setId(post.getId());
        response.setText(post.getText());
        response.setImageUrl(post.getImageUrl());
        response.setTags(post.getTags());
        response.setAuthorUsername(post.getAuthor().getUsername());
        response.setCreatedAt(post.getCreatedAt());
        response.setUpdatedAt(post.getUpdatedAt());
        return response;
    }

    public Page<PostResponse> getAllPosts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> posts = postRepository.findAll(pageable);

        return posts.map(post -> {
            PostResponse response = new PostResponse();
            response.setId(post.getId());
            response.setText(post.getText());
            response.setImageUrl(post.getImageUrl());
            response.setTags(post.getTags());
            response.setAuthorUsername(post.getAuthor().getUsername());
            response.setCreatedAt(post.getCreatedAt());
            response.setUpdatedAt(post.getUpdatedAt());
            return response;
        });
    }

    public Post getPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }
}
