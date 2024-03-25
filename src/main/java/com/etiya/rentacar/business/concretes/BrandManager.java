package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.BrandService;
import com.etiya.rentacar.business.dtos.requests.brand.CreateBrandRequest;
import com.etiya.rentacar.business.dtos.requests.brand.UpdateBrandRequest;
import com.etiya.rentacar.business.dtos.responses.brand.CreatedBrandResponse;
import com.etiya.rentacar.business.dtos.responses.brand.GetBrandListResponse;
import com.etiya.rentacar.business.dtos.responses.brand.GetBrandResponse;
import com.etiya.rentacar.business.dtos.responses.brand.UpdatedBrandResponse;
import com.etiya.rentacar.business.dtos.responses.transmission.UpdatedTransmissionResponse;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.BrandRepository;
import com.etiya.rentacar.entities.Brand;
import com.etiya.rentacar.entities.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    @Override
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {

        Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        brand.setCreatedDate(LocalDateTime.now());
        Brand savedBrand = brandRepository.save(brand);
        return modelMapperService.forResponse().map(savedBrand, CreatedBrandResponse.class);

    }

    @Override
    public UpdatedBrandResponse update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = findById(updateBrandRequest.getId());
        brand.setName(updateBrandRequest.getName());
        brand.setUpdatedDate(LocalDateTime.now());
        Brand savedBrand = brandRepository.save(brand);
        return modelMapperService.forResponse().map(savedBrand, UpdatedBrandResponse.class);
    }

    @Override
    public List<GetBrandListResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        return brands.stream().filter(brand -> brand.getDeletedDate() == null).map(brand ->
                modelMapperService.forResponse().map(brand, GetBrandListResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetBrandResponse getById(int id) {
        Brand brand = findById(id);
        return modelMapperService.forResponse().map(brand, GetBrandResponse.class);
    }


    @Override
    public void delete(int id) {
        Brand brand = findById(id);
        brand.setDeletedDate(LocalDateTime.now());
        brandRepository.save(brand);
    }

    private Brand findById(int id) {
        return brandRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Brand not found"));
    }
}
