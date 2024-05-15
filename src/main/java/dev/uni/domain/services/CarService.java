package dev.uni.domain.services;

import dev.uni.domain.entities.Car;
import dev.uni.infrastructure.repository.car.CarDto;

import java.util.List;

public interface CarService {

    Car save(CarDto carDto);

    List<Car> getAll();

    Car getOne(int id);
}
