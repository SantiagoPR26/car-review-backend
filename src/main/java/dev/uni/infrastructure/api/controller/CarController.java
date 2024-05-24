package dev.uni.infrastructure.api.controller;

import dev.uni.application.CarApplication;
import dev.uni.domain.entities.Car;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("api/car")
public class CarController {

    private final CarApplication carApplication;


    @GetMapping
    public ResponseEntity<List<Car>> getAll() {
        return ResponseEntity.ok(carApplication.getAll());
    }


    @PostMapping("/save")
    public ResponseEntity<Car> saveCar(@RequestBody Car car) {
        return new ResponseEntity<>(carApplication.saveCar(car), HttpStatus.CREATED);
    }

    @GetMapping("/one")
    public ResponseEntity<Car> getOne(@RequestParam int id) {
        return new ResponseEntity<>(carApplication.getOne(id), HttpStatus.OK);
    }

    @PutMapping("/viewCount")
    public void addViewCount(@RequestParam int id) {
        carApplication.updateViewCount(id);
    }
}
