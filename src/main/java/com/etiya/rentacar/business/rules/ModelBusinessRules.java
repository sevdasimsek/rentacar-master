package com.etiya.rentacar.business.rules;

import com.etiya.rentacar.dataAccess.abstracts.BrandRepository;
import com.etiya.rentacar.dataAccess.abstracts.ModelRepository;
import com.etiya.rentacar.entities.Brand;
import com.etiya.rentacar.entities.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ModelBusinessRules {
    private ModelRepository modelRepository;
    public void modelNameCannotBeDuplicated(String modelName){

        Optional<Model> model = modelRepository.findByNameIgnoreCase(modelName);

        if (model.isPresent()){
            throw new RuntimeException("Model Exists");
        }
    }

    public void brandIdIsExist(int id) {
        Optional<Model> model = modelRepository.findById(id);
        if (model.isEmpty()) {
            throw new RuntimeException("Model Id Is Not Exists...");
        }
    }
}
