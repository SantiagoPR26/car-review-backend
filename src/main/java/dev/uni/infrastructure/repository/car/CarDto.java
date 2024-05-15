package dev.uni.infrastructure.repository.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDto {

    private String photo;
    private String name;
    private String brand;
    private String model;
    private String plate;
}
