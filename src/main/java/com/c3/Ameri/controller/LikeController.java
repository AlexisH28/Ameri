package com.c3.Ameri.controller;

import com.c3.Ameri.entity.Post;
import com.c3.Ameri.entity.User;
import com.c3.Ameri.service.LikeService;
import com.c3.Ameri.service.PostService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    private final LikeService likeService;
    private final PostService postService;

    public LikeController(LikeService likeService, PostService postService) {
        this.likeService = likeService;
        this.postService = postService;
    }

    @PostMapping("/post/{postId}")
    public void toggleLike(@PathVariable Long postId, @AuthenticationPrincipal UserDetails userDetails) {
        Post post = postService.getPostById(postId);
        User user = new User();
        user.setUsername(userDetails.getUsername());
        likeService.toggleLike(post, user);
    }

    @GetMapping("/post/{postId}/count")
    public long countLikes(@PathVariable Long postId) {
        Post post = postService.getPostById(postId);
        return likeService.countLikes(post);
    }
}
