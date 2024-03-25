package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.BrandService;
import com.etiya.rentacar.business.dtos.requests.brand.CreateBrandRequest;
import com.etiya.rentacar.business.dtos.requests.brand.UpdateBrandRequest;
import com.etiya.rentacar.business.dtos.responses.brand.CreatedBrandResponse;
import com.etiya.rentacar.business.dtos.responses.brand.GetBrandListResponse;
import com.etiya.rentacar.business.dtos.responses.brand.GetBrandResponse;
import com.etiya.rentacar.business.dtos.responses.brand.UpdatedBrandResponse;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.BrandRepository;
import com.etiya.rentacar.entities.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;
    private ModelMapperService modelMapperService;


    @Override
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {
        //todo: business rules

        Brand brand = new Brand();
        brand.setName(createBrandRequest.getName());

        brandRepository.save(brand);

        CreatedBrandResponse response = new CreatedBrandResponse();
        response.setId(brand.getId());
        response.setName(brand.getName());
        response.setCreatedDate(brand.getCreatedDate());

        return response;

    }

    @Override
    public UpdatedBrandResponse update(UpdateBrandRequest brand) {
        Brand brandToUpdate = brandRepository.findById(brand.getId()).orElseThrow(() -> new IllegalArgumentException("Brand not found"));
        brandToUpdate.setName(brand.getName());


        brandRepository.save(brandToUpdate);

        UpdatedBrandResponse response = new UpdatedBrandResponse();
        response.setId(brandToUpdate.getId());
        response.setName(brandToUpdate.getName());
        response.setUpdatedDate(brandToUpdate.getUpdatedDate());

        return response;

    }

    @Override
    public List<GetBrandListResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        return brands.stream().map(brand -> modelMapperService.forResponse().map())
    }

    @Override
    public GetBrandResponse getById(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Brand not found"));
        return modelMapperService.forResponse().map(brand, GetBrandResponse.class);
    }

    @Override
    public Brand getByBrandId(int id) {

        Brand brand = brandRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Brand not found"));
        return brand;
    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }
}
