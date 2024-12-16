package com.example.carwala.app.service;

import com.example.carwala.app.entity.Car;

import java.util.List;

public interface CarService {


    Car addCar(Car car);
    List<Car> getAllCars();
    List<Car> getAvailabeCars();
    List<Car> getCarsByType(String type);
    Car updateCarAvalability(Long carId, boolean available);



}
