package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.CarService;
import com.etiya.rentacar.business.abstracts.ModelService;
import com.etiya.rentacar.business.dtos.requests.car.CreateCarRequest;
import com.etiya.rentacar.business.dtos.requests.car.UpdateCarRequest;
import com.etiya.rentacar.business.dtos.responses.brand.GetBrandListResponse;
import com.etiya.rentacar.business.dtos.responses.car.CreatedCarResponse;
import com.etiya.rentacar.business.dtos.responses.car.GetCarListResponse;
import com.etiya.rentacar.business.dtos.responses.car.GetCarResponse;
import com.etiya.rentacar.business.dtos.responses.car.UpdatedCarResponse;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.CarRepository;
import com.etiya.rentacar.entities.Brand;
import com.etiya.rentacar.entities.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

    private final CarRepository carRepository;
    private final ModelService modelService;
    private ModelMapperService modelMapperService;

    @Override
    public CreatedCarResponse add(CreateCarRequest createCarRequest) {
        Car car = modelMapperService.forRequest().map(createCarRequest, Car.class);
        car.setCreatedDate(LocalDateTime.now());
        Car savedCar = carRepository.save(car);
        return modelMapperService.forResponse().map(savedCar, CreatedCarResponse.class);


    }

    @Override
    public UpdatedCarResponse update(UpdateCarRequest updateCarRequest) {
        Car updatedCar = modelMapperService.forRequest().map(updateCarRequest, Car.class);
        updatedCar.setUpdatedDate(LocalDateTime.now());
        Car savedCar = carRepository.save(updatedCar);
        return modelMapperService.forResponse().map(savedCar, UpdatedCarResponse.class);
    }

    @Override
    public List<GetCarListResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        return cars.stream().filter(car -> car.getDeletedDate() == null)
                .map(car -> modelMapperService.forResponse()
                        .map(car, GetCarListResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetCarResponse getById(int id) {
        Car car = findById(id);
        return modelMapperService.forResponse().map(car, GetCarResponse.class);
    }


    @Override
    public void delete(int id) {
        Car car = findById(id);
        car.setDeletedDate(LocalDateTime.now());
        carRepository.save(car);

    }

    private Car findById(int id) {
        return carRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Brand not found"));
    }
}
