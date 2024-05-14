package dev.uni.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {

    private Long id;
    private Car car;
    private Comment comment;
    private Integer viewCount;

}
