package dev.uni.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {

    private Long id;
    private String photo;
    private String name;
    private String brand;
    private String model;
    private String plate;

}
