package dev.uni.application;

import dev.uni.domain.entities.Car;
import dev.uni.domain.entities.Comment;
import dev.uni.domain.services.CarService;
import dev.uni.domain.services.CommentService;
import dev.uni.infrastructure.repository.car.CarDto;
import dev.uni.infrastructure.repository.comment.CommentDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CommentApplication {

    private final CommentService commentService;
    private final CarService carService;

    public Comment saveComment(Comment comment) {
        CommentDto commentDto = new CommentDto(comment.getContent(),
                comment.getDate(),
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
        CarDto carDto = new CarDto(car.getPhoto(),
                car.getName(),
                car.getBrand(),
                car.getModel(),
                car.getPlate(),
                car.getCommentList(),
                car.getViewCount());
        carService.update(id, carDto);
    }

    public void updateLike(int id) {
        int one = 1;
        Comment comment = commentService.getOne(id);
        CommentDto commentDto = new CommentDto(comment.getContent(),
                comment.getDate(),
                comment.getUsername(),
                comment.getLike(),
                comment.getDislike(),
                comment.getCarId());
        commentDto.setLike(one++);
        commentService.update(id, commentDto);
    }

    public void updateDislike(int id) {
        int one = 1;
        Comment comment = commentService.getOne(id);
        CommentDto commentDto = new CommentDto(comment.getContent(),
                comment.getDate(),
                comment.getUsername(),
                comment.getLike(),
                comment.getDislike(),
                comment.getCarId());
        commentDto.setDislike(one++);
        commentService.update(id, commentDto);
    }
}
