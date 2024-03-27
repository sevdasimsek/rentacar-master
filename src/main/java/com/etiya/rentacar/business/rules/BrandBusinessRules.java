package com.etiya.rentacar.business.rules;

import com.etiya.rentacar.core.exceptions.types.BusinessException;
import com.etiya.rentacar.dataAccess.abstracts.BrandRepository;
import com.etiya.rentacar.entities.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandBusinessRules {

    private BrandRepository brandRepository;
    public void brandNameCannotBeDuplicated(String brandName){

        Optional<Brand> brand = brandRepository.findByNameIgnoreCase(brandName.trim());

        if (brand.isPresent()){//isPresent => var ise demektir.
            throw new BusinessException("Brand Exists");
        }
    }

    public void brandIdIsExist(int id) {
        Optional<Brand> brand = brandRepository.findById(id);
        if (brand.isEmpty()) {
            throw new BusinessException("Brand Id Is Not Exists...");
        }
    }
}
