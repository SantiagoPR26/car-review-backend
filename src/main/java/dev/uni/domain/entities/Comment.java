package dev.uni.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {

    private Long id;
    private String content;
    private LocalDateTime date;
    private User username;
    private Integer like;
    private Integer dislike;
}
