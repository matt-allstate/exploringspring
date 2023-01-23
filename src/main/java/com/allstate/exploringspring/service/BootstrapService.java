package com.allstate.exploringspring.service;

import com.allstate.exploringspring.data.CarRepository;
import com.allstate.exploringspring.data.DriverRepository;
import com.allstate.exploringspring.domain.Car;
import com.allstate.exploringspring.domain.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class BootstrapService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private DriverRepository driverRepository;

    @PostConstruct
    public void setUpInitialData() {
        int numberOfCars = carRepository.findAll().size();
        if (numberOfCars == 0) {
            Car newCar = new Car("Prius", "Toyota");
            Car savedCar = carRepository.save(newCar);
            System.out.println("Car saved with id " + savedCar.getId());
        }
        if (driverRepository.count() == 0) {
            Car newCar1 = new Car("Panda", "Fiat");
            Car newCar2 = new Car("Cleo", "Renault");
            List<Car> cars = new ArrayList<>();
            cars.add(newCar1);
            cars.add(newCar2);
            Driver driver = new Driver(null, "Matt", cars);
            newCar1.setDriver(driver);
            newCar2.setDriver(driver);
            driverRepository.save(driver);
        }
    }

}
