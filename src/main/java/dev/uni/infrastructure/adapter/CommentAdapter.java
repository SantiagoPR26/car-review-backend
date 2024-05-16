package dev.uni.infrastructure.adapter;

import dev.uni.domain.entities.Comment;
import dev.uni.domain.services.CommentService;
import dev.uni.infrastructure.repository.comment.CommentDto;
import dev.uni.infrastructure.repository.comment.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Service
public class CommentAdapter implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public Comment save(CommentDto commentDto) {
        int id = autoIncrement();
        Comment comment = new Comment(id, commentDto.getContent(), commentDto.getDate(),
                commentDto.getUsername(),
                commentDto.getLike(),
                commentDto.getDislike(),
                commentDto.getCarId());
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAll(){ return commentRepository.findAll();}

    @Override
    public Comment getOne(int id){ return commentRepository.findById(id).get(); }

    private int autoIncrement(){
        List<Comment> comments = commentRepository.findAll();
        return comments.isEmpty() ? 1 : comments.stream().max(Comparator.comparing(Comment::getId)).get().getId() + 1;
    }

}
