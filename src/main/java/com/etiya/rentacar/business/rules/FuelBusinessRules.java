package com.etiya.rentacar.business.rules;

import com.etiya.rentacar.dataAccess.abstracts.FuelRepository;
import com.etiya.rentacar.entities.Brand;
import com.etiya.rentacar.entities.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FuelBusinessRules {
    private FuelRepository fuelRepository;
    public void fuelNameCannotBeDuplicated(String fuelName){
        Optional<Fuel> fuel = fuelRepository.findByNameIgnoreCase(fuelName);
        if (fuel.isPresent()){
            throw new RuntimeException("Fuel Exists");
        }
    }

    public void fuelIdIsExist(int id) {
        Optional<Fuel> fuel = fuelRepository.findById(id);
        if (fuel.isEmpty()) {
            throw new RuntimeException("Fuel Id Is Not Exists...");
        }
    }
}
