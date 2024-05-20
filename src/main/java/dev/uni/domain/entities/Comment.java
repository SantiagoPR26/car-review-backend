package dev.uni.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "comments")
public class Comment {

    @Id
    private int id;
    private String content;
    private LocalDateTime date;
    private String username;
    private int like;
    private int dislike;
    private int carId;

}
