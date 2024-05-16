package dev.uni.infrastructure.adapter;

import dev.uni.domain.entities.Car;
import dev.uni.domain.entities.Comment;
import dev.uni.domain.services.CarService;
import dev.uni.infrastructure.repository.car.CarDto;
import dev.uni.infrastructure.repository.car.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Service
public class CarAdapter implements CarService {

    private final CarRepository carRepository;

    @Override
    public Car save(CarDto carDto) {
        int id = autoIncrement();
        Car car = new Car(id, carDto.getPhoto(),
                carDto.getName(),
                carDto.getBrand(),
                carDto.getModel(),
                carDto.getPlate(),
                carDto.getCommentList(),
                carDto.getViewCount());
        return carRepository.save(car);
    }

    @Override
    public void addComment(int id, Comment comment) {
        Car car = carRepository.findById(id).get();
        car.getCommentList().add(comment);
        carRepository.save(car);
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car getOne(int id) {
        return carRepository.findById(id).get();
    }


    private int autoIncrement() {
        List<Car> cars = carRepository.findAll();
        return cars.isEmpty() ? 1 : cars.stream().max(Comparator.comparing(Car::getId)).get().getId() + 1;
    }


}
