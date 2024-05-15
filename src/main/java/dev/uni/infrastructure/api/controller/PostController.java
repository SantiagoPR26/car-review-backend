package dev.uni.infrastructure.api.controller;

import dev.uni.application.PostApplication;
import dev.uni.domain.entities.Post;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {

    private final PostApplication postApplication;

    @PostMapping
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
        return new ResponseEntity<>(postApplication.savePost(post), HttpStatus.CREATED);
    }
}
