package com.allstate.exploringspring.service;

import com.allstate.exploringspring.data.CarRepository;
import com.allstate.exploringspring.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }
}
