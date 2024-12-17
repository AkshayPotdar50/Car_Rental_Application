package com.example.carwala.app.controller;

import com.example.carwala.app.entity.Car;
import com.example.carwala.app.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarServiceImpl carService;

    @Autowired
    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        Car createdCar = carService.addCar(car);
        return ResponseEntity.ok(createdCar);
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/available")
    public ResponseEntity<List<Car>> getAvailableCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Car>> getCarsByType(@PathVariable String type) {
        return ResponseEntity.ok(carService.getCarsByType(type));
    }

    @PutMapping("/{id}/availability/{available}")
    public ResponseEntity<Car> updateCarAvailability(
            @PathVariable Long id, @PathVariable boolean available) {
        Car updatedCar = carService.updateCarAvalability(id, available);
        return ResponseEntity.ok(updatedCar);
    }

}