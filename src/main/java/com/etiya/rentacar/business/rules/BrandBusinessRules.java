package com.etiya.rentacar.business.rules;

import com.etiya.rentacar.dataAccess.abstracts.BrandRepository;
import com.etiya.rentacar.entities.Brand;
import com.etiya.rentacar.entities.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandBusinessRules {

    private BrandRepository brandRepository;
    public void brandNameCannotBeDuplicated(String brandName){

        Optional<Brand> brand = brandRepository.findByNameIgnoreCase(brandName);

        if (brand.isPresent()){//isPresent => var ise demektir.
            throw new RuntimeException("Brand Exists");
        }
    }

    public void brandIdIsExist(int id) {
        Optional<Brand> brand = brandRepository.findById(id);
        if (brand.isEmpty()) {
            throw new RuntimeException("Brand Id Is Not Exists...");
        }
    }
}
