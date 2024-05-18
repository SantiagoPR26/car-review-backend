package dev.uni.infrastructure.api.controller;

import dev.uni.application.CommentApplication;
import dev.uni.domain.entities.Comment;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentApplication commentApplication;

    @PostMapping
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment) {
        return new ResponseEntity<>(commentApplication.saveComment(comment), HttpStatus.CREATED);
    }

    @PutMapping("/like")
    public void addLike(@RequestParam int id) {
        commentApplication.updateLike(id);
    }

    @PutMapping("/dislike")
    public void addDislike(@RequestParam int id) {
        commentApplication.updateDislike(id);
    }
}
