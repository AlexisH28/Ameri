package com.c3.Ameri.repository;

import com.c3.Ameri.entity.Like;
import com.c3.Ameri.entity.Post;
import com.c3.Ameri.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByPostAndUser(Post post, User user);
    long countByPost(Post post);
}
