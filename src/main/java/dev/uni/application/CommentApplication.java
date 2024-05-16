package dev.uni.application;

import dev.uni.domain.entities.Comment;
import dev.uni.domain.services.CommentService;
import dev.uni.infrastructure.repository.comment.CommentDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CommentApplication {

    private final CommentService commentService;

    public Comment saveComment(Comment comment){
        CommentDto commentDto = new CommentDto(comment.getContent(),
                comment.getDate(),
                comment.getUsername(),
                comment.getLike(),
                comment.getDislike());
        return commentService.save(commentDto);
    }
}
