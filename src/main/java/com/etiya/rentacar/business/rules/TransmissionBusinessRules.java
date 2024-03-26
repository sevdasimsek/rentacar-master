package com.etiya.rentacar.business.rules;

import com.etiya.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.etiya.rentacar.entities.Brand;
import com.etiya.rentacar.entities.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TransmissionBusinessRules {
    private TransmissionRepository transmissionRepository;

    public void transmissionNameCannotBeDuplicated(String transmissionName){
        Optional<Transmission> transmission = transmissionRepository.findByNameIgnoreCase(transmissionName);

        if (transmission.isPresent()){
            throw new RuntimeException("Transmission Exists");
        }
    }
    public void transmissionIdIsExist(int id) {
        Optional<Transmission> transmission = transmissionRepository.findById(id);
        if (transmission.isEmpty()) {
            throw new RuntimeException("Transmission Id Is Not Exists...");
        }
    }
}
