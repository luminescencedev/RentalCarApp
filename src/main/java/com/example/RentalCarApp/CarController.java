package com.example.RentalCarApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CarController {

    ArrayList<Car>cars = new ArrayList<Car>();

    public CarController() {
        Car car = new Car("AA11BB", "ferrari", 2000);
        cars.add(car);
        car = new Car("BB22CC", "porsche", 1000);
        cars.add(car);
        car = new Car("CC33DD", "peugeot", 500);
        cars.add(car);
        car = new Car("DD44EE", "lancia", 500);
        cars.add(car);
        car = new Car("EE55FF", "lancia2", 2500);
        cars.add(car);
        car = new Car("FF66GG", "citroen", 2500);
        cars.add(car);
    }

    @GetMapping("/cars")
    public ArrayList<Car> getCars() {
        return cars;
    }

    @GetMapping("/cars/{plateNumber}")
    public Car showAllCar(@PathVariable("plateNumber") String plaque){
        int i=0;
        while(i<cars.size() && !cars.get(i).getPlateNumber().equals(plaque)){
            i++;
        }
        if(i < cars.size()){
            return cars.get(i);
        } else {
            return null;
        }
    }
}