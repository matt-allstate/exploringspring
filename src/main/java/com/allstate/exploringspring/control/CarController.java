package com.allstate.exploringspring.control;

import com.allstate.exploringspring.domain.Car;
import com.allstate.exploringspring.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/car")
@CrossOrigin
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping()
    public List<Car> getAllCars() {
        Car car1 = new Car( "Fiesta", "Ford");
        Car car2 = new Car( "Micra", "Nissan");
        Car car3 = new Car( "Berlingo", "Citroen");
        Car car4 = new Car("Ka", "Ford");
        Car car5 = new Car("Cleo", "Renault");
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        return cars;
    }

    @GetMapping("/init")
    public String setUpData() {
        Car car1 = new Car( "Fiesta", "Ford");
        carService.saveCar(car1);
        return "ok";
    }

}
