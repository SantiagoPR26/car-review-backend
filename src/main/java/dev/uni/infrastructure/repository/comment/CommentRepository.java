package dev.uni.infrastructure.repository.comment;

import dev.uni.domain.entities.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, Integer> {

    @Query("{ 'carId': ?0 }")
    List<Comment> findAllByCarId(Integer carId);
}
