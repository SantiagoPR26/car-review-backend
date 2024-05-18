package dev.uni.infrastructure.api.controller;

import dev.uni.application.CarApplication;
import dev.uni.domain.entities.Car;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/car")
public class CarController {

    private final CarApplication carApplication;

    @PostMapping("/save")
    public ResponseEntity<Car> saveCar(@RequestBody Car car) {
        return new ResponseEntity<>(carApplication.saveCar(car), HttpStatus.CREATED);
    }
}
