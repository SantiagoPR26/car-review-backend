package dev.uni.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "cars")
public class Car {

    @Id
    private int id;
    private String price;
    private String photo;
    private String name;
    private String km;
    private String brand;
    private String model;
    private String plate;
    @DBRef
    private List<Comment> commentList;
    private String ubication;
    private int viewCount;

}
