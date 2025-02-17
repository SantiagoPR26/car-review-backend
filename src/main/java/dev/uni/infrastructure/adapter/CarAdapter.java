package dev.uni.infrastructure.adapter;

import dev.uni.domain.entities.Car;
import dev.uni.domain.entities.Comment;
import dev.uni.domain.services.CarService;
import dev.uni.infrastructure.repository.car.CarDto;
import dev.uni.infrastructure.repository.car.CarRepository;
import dev.uni.infrastructure.share.CarNotFoundException;
import dev.uni.infrastructure.share.ExceptionCode;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Service
public class CarAdapter implements CarService {

    private final CarRepository carRepository;
    private final MessageSource messageSource;

    @Override
    public Car save(CarDto carDto) {
        int id = autoIncrement();
        Car car = new Car(id, carDto.getPrice(),
                carDto.getPhoto(),
                carDto.getName(),
                carDto.getKm(),
                carDto.getBrand(),
                carDto.getModel(),
                carDto.getPlate(),
                carDto.getCommentList(),
                carDto.getUbication(),
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
        return carRepository.findById(id).orElseThrow(() ->
                new CarNotFoundException(
                        messageSource.getMessage(ExceptionCode.CAR_NOT_FOUND.getType(),
                                new Object[]{id}, LocaleContextHolder.getLocale())));
    }

    @Override
    public void update(int id, CarDto carDto) {
        Car car = carRepository.findById(id).get();
        car.setPrice(carDto.getPrice());
        car.setPhoto(carDto.getPhoto());
        car.setName(carDto.getName());
        car.setKm(carDto.getKm());
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setPlate(carDto.getPlate());
        car.setUbication(carDto.getUbication());
        car.setCommentList(carDto.getCommentList());
        car.setViewCount(carDto.getViewCount());
        carRepository.save(car);
    }


    private int autoIncrement() {
        List<Car> cars = carRepository.findAll();
        return cars.isEmpty() ? 1 : cars.stream().max(Comparator.comparing(Car::getId)).get().getId() + 1;
    }
}