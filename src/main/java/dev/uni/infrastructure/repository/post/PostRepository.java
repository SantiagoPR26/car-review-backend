package dev.uni.infrastructure.repository.post;

import dev.uni.domain.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, Integer> {
}
