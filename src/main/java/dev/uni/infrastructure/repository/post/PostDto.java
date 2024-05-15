package dev.uni.infrastructure.repository.post;

import dev.uni.domain.entities.Comment;
import dev.uni.infrastructure.repository.car.CarDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDto {

    private CarDto carDto;
    private Comment comment;
    private int viewCount;
}
