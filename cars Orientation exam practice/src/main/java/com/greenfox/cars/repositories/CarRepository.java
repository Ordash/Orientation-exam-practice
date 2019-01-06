package com.greenfox.cars.repositories;

import com.greenfox.cars.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByLicencePlateContains(String lp);

    List<Car> findAllByBrand(String brand);

    @Query(value = "SELECT c FROM Car c where c.licencePlate like 'RB%'")
    List<Car> findAllPoliceCars();

    @Query(value = "SELECT c FROM Car c where c.licencePlate like 'DT%'")
    List<Car> findAllDiplomatCars();
}
