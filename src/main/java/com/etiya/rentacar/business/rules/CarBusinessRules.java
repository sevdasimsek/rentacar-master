package com.etiya.rentacar.business.rules;

import com.etiya.rentacar.core.exceptions.types.BusinessException;
import com.etiya.rentacar.dataAccess.abstracts.CarRepository;
import com.etiya.rentacar.entities.Brand;
import com.etiya.rentacar.entities.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CarBusinessRules {

    private CarRepository carRepository;

    public void carIdIsExist(int id) {
        Optional<Car> car = carRepository.findById(id);
        if (car.isEmpty()) {
            throw new BusinessException("Car Id Is Not Exists...");
        }
    }
}
