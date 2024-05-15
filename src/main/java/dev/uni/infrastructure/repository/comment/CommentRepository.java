package dev.uni.infrastructure.repository.comment;

import dev.uni.domain.entities.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment, Integer> {
}
