package dev.uni.infrastructure.adapter;

import dev.uni.domain.entities.Post;
import dev.uni.domain.services.PostService;
import dev.uni.infrastructure.repository.post.PostDto;
import dev.uni.infrastructure.repository.post.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PostAdapter implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post save(PostDto postDto) {
        return null;
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public Post getOne(int id) {
        return postRepository.findById(id).get();
    }
}
