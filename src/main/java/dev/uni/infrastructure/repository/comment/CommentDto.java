package dev.uni.infrastructure.repository.comment;

import dev.uni.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDto {

    private int id;
    private String content;
    private LocalDateTime date;
    private String username;
    private int like;
    private int dislike;
    private int carId;
}
