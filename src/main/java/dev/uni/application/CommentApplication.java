package dev.uni.application;

import dev.uni.domain.entities.Car;
import dev.uni.domain.entities.Comment;
import dev.uni.domain.services.CarService;
import dev.uni.domain.services.CommentService;
import dev.uni.infrastructure.repository.car.CarDto;
import dev.uni.infrastructure.repository.comment.CommentDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class CommentApplication {

    private final CommentService commentService;
    private final CarService carService;

    public List<Comment> getAll() {
        return commentService.getAll();
    }

    public List<Comment> getAllCommentsByCarId(int id) {
        return commentService.getAllCommentsByCarId(id);
    }

    public Comment getOne(int id) {
        return commentService.getOne(id);
    }

    public Comment saveComment(Comment comment) {
        CommentDto commentDto = new CommentDto(comment.getContent(),
                LocalDateTime.now(),
                comment.getUsername(),
                comment.getLike(),
                comment.getDislike(),
                comment.getCarId());
        addComment(commentDto.getCarId(), comment);
        return commentService.save(commentDto);
    }

    public void addComment(int id, Comment comment) {
        Car car = carService.getOne(id);
        car.getCommentList().add(comment);
        CarDto carDto = new CarDto(car.getPrice(),
                car.getPhoto(),
                car.getName(),
                car.getKm(),
                car.getBrand(),
                car.getModel(),
                car.getPlate(),
                car.getCommentList(),
                car.getUbication(),
                car.getViewCount());
        carService.update(id, carDto);
    }

    public void updateLike(int id) {
        Comment comment = commentService.getOne(id);
        CommentDto commentDto = new CommentDto(comment.getContent(),
                comment.getDate(),
                comment.getUsername(),
                comment.getLike(),
                comment.getDislike(),
                comment.getCarId());
        commentDto.setLike(comment.getLike() + 1);
        commentService.update(id, commentDto);
    }

    public void updateDislike(int id) {
        Comment comment = commentService.getOne(id);
        CommentDto commentDto = new CommentDto(comment.getContent(),
                comment.getDate(),
                comment.getUsername(),
                comment.getLike(),
                comment.getDislike(),
                comment.getCarId());
        commentDto.setDislike(comment.getDislike() + 1);
        commentService.update(id, commentDto);
    }
}