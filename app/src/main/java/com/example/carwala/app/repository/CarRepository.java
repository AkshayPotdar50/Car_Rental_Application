package com.example.carwala.app.repository;
import com.example.carwala.app.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {


    List<Car> findByAvailable(boolean available);


    List<Car> findByType(String type);


    List<Car> findByTypeAndAvailable(String type, boolean available);
}

