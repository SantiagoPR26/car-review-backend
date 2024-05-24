package dev.uni.application;

import dev.uni.domain.entities.Car;
import dev.uni.domain.entities.Comment;
import dev.uni.domain.services.CarService;
import dev.uni.infrastructure.repository.car.CarDto;
import dev.uni.infrastructure.repository.comment.CommentDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CarApplication {

    private final CommentApplication commentApplication;
    private final CarService carService;

    public Car saveCar(Car car) {
        CarDto carDto = new CarDto(car.getPrice(),
                car.getPhoto(),
                car.getName(),
                car.getKm(),
                car.getBrand(),
                car.getModel(),
                car.getPlate(),
                car.getCommentList(),
                car.getUbication(),
                car.getViewCount());

        carService.save(carDto);

        for (Comment comment : car.getCommentList()) {
            commentApplication.saveComment(comment);
        }

        return car;
    }

    public List<Car> getAll() {
        return carService.getAll();
    }

    public Car getOne(int id) {
        return carService.getOne(id);
    }

    public void updateviewCount(int id) {
        Car car = carService.getOne(id);
        CarDto carDto = new CarDto(car.getPrice(),
                car.getPhoto(),
                car.getName(),
                car.getKm(),
                car.getBrand(),
                car.getModel(),
                car.getPlate(),
                car.getCommentList(),
                car.getUbication(),
                car.getViewCount());
        carDto.setViewCount(car.getViewCount() + 1);
        carService.update(id, carDto);
    }
}
