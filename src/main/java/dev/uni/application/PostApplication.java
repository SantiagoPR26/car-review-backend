package dev.uni.application;

import dev.uni.domain.entities.Post;
import dev.uni.domain.services.PostService;
import dev.uni.infrastructure.repository.post.PostDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PostApplication {

    private final PostService postService;

    public Post savePost(Post post) {
        PostDto postDto = new PostDto();
        return postService.save(postDto);
    }
}
