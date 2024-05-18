package dev.uni.infrastructure.api.controller;

import dev.uni.application.CommentApplication;
import dev.uni.domain.entities.Comment;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentApplication commentApplication;

    @PostMapping
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment){
        return new ResponseEntity<>(commentApplication.saveComment(comment), HttpStatus.CREATED);
    }
}
