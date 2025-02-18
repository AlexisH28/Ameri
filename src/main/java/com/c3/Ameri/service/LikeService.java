package com.c3.Ameri.service;

import com.c3.Ameri.entity.Like;
import com.c3.Ameri.entity.Post;
import com.c3.Ameri.entity.User;
import com.c3.Ameri.repository.LikeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikeService {

    private final LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Transactional
    public void toggleLike(Post post, User user) {
        likeRepository.findByPostAndUser(post, user).ifPresentOrElse(
                likeRepository::delete,
                () -> {
                    Like like = new Like();
                    like.setPost(post);
                    like.setUser(user);
                    likeRepository.save(like);
                }
        );
    }

    public long countLikes(Post post) {
        return likeRepository.countByPost(post);
    }
}
