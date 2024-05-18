package dev.uni.application;

import dev.uni.domain.entities.Car;
import dev.uni.domain.entities.Comment;
import dev.uni.domain.services.CarService;
import dev.uni.infrastructure.repository.car.CarDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CarApplication {

    private final CommentApplication commentApplication;
    private final CarService carService;

    public Car saveCar(Car car) {
        CarDto carDto = new CarDto(car.getPhoto(),
                car.getName(),
                car.getBrand(),
                car.getModel(),
                car.getPlate(),
                car.getCommentList(),
                car.getViewCount());

        for (Comment comment : car.getCommentList()) {
            commentApplication.saveComment(comment);
        }

        return carService.save(carDto);
    }

    public Car getOne(int id) {
        return carService.getOne(id);
    }
}
