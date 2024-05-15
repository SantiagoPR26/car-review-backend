package dev.uni.domain.services;

import dev.uni.domain.entities.Post;
import dev.uni.infrastructure.repository.post.PostDto;

import java.util.List;

public interface PostService {

    Post save(PostDto postDto);

    List<Post> getAll();

    Post getOne(int id);
}
