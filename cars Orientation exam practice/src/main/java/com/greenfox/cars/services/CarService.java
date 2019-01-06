package com.greenfox.cars.services;

import com.greenfox.cars.entities.Car;
import com.greenfox.cars.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findByLicencePlate(String lp){
        if(lp.matches("[A-Z]{0,4}-?[0-9]{0,4}") && lp.length() < 8 && !carRepository.findByLicencePlateContains(lp).isEmpty()) {
            return carRepository.findByLicencePlateContains(lp);
        }
        return null;
    }

    public List<Car> findAllPoliceCars(){
        return carRepository.findAllPoliceCars();
    }

    public List<Car> findAllDiplomatCars(){
        return carRepository.findAllDiplomatCars();
    }

    public List<Car> findAllByBrand(String b) {
        return carRepository.findAllByBrand(b);
    }
}
