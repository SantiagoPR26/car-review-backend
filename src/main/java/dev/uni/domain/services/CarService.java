package dev.uni.domain.services;

import dev.uni.domain.entities.Car;
import dev.uni.domain.entities.Comment;
import dev.uni.infrastructure.repository.car.CarDto;

import java.util.List;

public interface CarService {

    Car save(CarDto carDto);

    void addComment(int Id, Comment comment);

    List<Car> getAll();

    Car getOne(int id);

    void update(int id, CarDto carDto);
}
