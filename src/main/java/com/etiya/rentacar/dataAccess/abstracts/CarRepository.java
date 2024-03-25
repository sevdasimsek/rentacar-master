package com.etiya.rentacar.dataAccess.abstracts;

import com.etiya.rentacar.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
