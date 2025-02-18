package com.c3.Ameri;

import com.c3.Ameri.dto.Response.PostResponse;
import com.c3.Ameri.entity.Post;
import com.c3.Ameri.repository.PostRepository;
import com.c3.Ameri.service.PostService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    @Test
    public void testGetAllPosts() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post());
        when(postRepository.findAll()).thenReturn(posts);

        List<PostResponse> result = postService.getAllPosts();
        assertEquals(1, result.size());
    }
}
