package dev.uni.domain.services;

import dev.uni.domain.entities.Comment;
import dev.uni.infrastructure.repository.comment.CommentDto;

import java.util.List;

public interface CommentService {

    Comment save(CommentDto commentDto);

    List<Comment> getAll();

    Comment getOne(int id);
}
