package com.example.RentalCarApp;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/cars")
class CarController {
    private final Map<String, Car> cars = new HashMap<>();

    public CarController() {
        cars.put("11AA22", new Car("11AA22", "Ferrari", 100, false));
        cars.put("22BB33", new Car("22BB33", "Tesla", 80, false));
    }

    @GetMapping
    public List<Car> listOfCars() {
        return new ArrayList<>(cars.values());
    }

    @GetMapping("/{plateNumber}")
    public Car aCar(@PathVariable("plateNumber") String plateNumber) {
        return cars.getOrDefault(plateNumber, null);
    }

    @PutMapping("/{plateNumber}")
    public void rentOrGetBack(@PathVariable("plateNumber") String plateNumber,
                              @RequestParam("rent") boolean rent,
                              @RequestBody(required = false) Dates dates) {
        Car car = cars.get(plateNumber);
        if (car != null) {
            car.setRented(rent);
        }
    }
}
