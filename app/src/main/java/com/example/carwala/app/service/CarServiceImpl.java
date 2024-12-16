package com.example.carwala.app.service;

import com.example.carwala.app.entity.Car;
import com.example.carwala.app.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> getAvailabeCars() {
        return carRepository.findByAvailable(true);
    }

    @Override
    public List<Car> getCarsByType(String type) {
        return carRepository.findByType(type);
    }

    @Override
    public Car updateCarAvalability(Long carId, boolean available) {
        Car car =carRepository.findById(carId).orElseThrow(()->new RuntimeException("car not found"));
        car.setAvailable(available);
        return carRepository.save(car);
    }
}
