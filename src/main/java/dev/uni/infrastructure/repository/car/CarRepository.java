package dev.uni.infrastructure.repository.car;

import dev.uni.domain.entities.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends MongoRepository<Car, Integer> {

}
