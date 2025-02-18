package com.c3.Ameri.repository;

import com.c3.Ameri.entity.Comment;
import com.c3.Ameri.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostOrderByCreatedAtAsc(Post post);
    List<Comment> findAllByPostOrderByCreatedAtDesc(Post post);
}
