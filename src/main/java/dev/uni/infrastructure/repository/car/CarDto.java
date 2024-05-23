package dev.uni.infrastructure.repository.car;

import dev.uni.domain.entities.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDto {

    private String price;
    private String photo;
    private String name;
    private String km;
    private String brand;
    private String model;
    private String plate;
    private List<Comment> commentList;
    private String ubication;
    private int viewCount;
}
