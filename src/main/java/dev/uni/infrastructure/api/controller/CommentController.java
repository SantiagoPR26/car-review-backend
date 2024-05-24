package dev.uni.infrastructure.api.controller;

import dev.uni.application.CommentApplication;
import dev.uni.domain.entities.Comment;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("api/comment")
public class CommentController {

    private final CommentApplication commentApplication;

    @PostMapping
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment) {
        return new ResponseEntity<>(commentApplication.saveComment(comment), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getAll() {
        return ResponseEntity.ok(commentApplication.getAll());
    }

    @GetMapping("getByCarId")
    public ResponseEntity<List<Comment>> getAllCommentsByCarId(@RequestParam int id) {
        return ResponseEntity.ok(commentApplication.getAllCommentsByCarId(id));
    }

    @GetMapping("/one")
    public ResponseEntity<Comment> getOne(@RequestParam int id) {
        return new ResponseEntity<>(commentApplication.getOne(id), HttpStatus.OK);
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
