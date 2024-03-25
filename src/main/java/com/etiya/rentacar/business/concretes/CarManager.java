package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.CarService;
import com.etiya.rentacar.business.abstracts.ModelService;
import com.etiya.rentacar.business.dtos.requests.car.CreateCarRequest;
import com.etiya.rentacar.business.dtos.requests.car.UpdateCarRequest;
import com.etiya.rentacar.business.dtos.responses.car.CreatedCarResponse;
import com.etiya.rentacar.business.dtos.responses.car.GetCarListResponse;
import com.etiya.rentacar.business.dtos.responses.car.GetCarResponse;
import com.etiya.rentacar.business.dtos.responses.car.UpdatedCarResponse;
import com.etiya.rentacar.dataAccess.abstracts.CarRepository;
import com.etiya.rentacar.entities.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

    private final CarRepository carRepository;
    private final ModelService modelService;

    @Override
    public CreatedCarResponse add(CreateCarRequest createCarRequest) {
        Car car = new Car();

        car.setModel(modelService.getByModelId(createCarRequest.getModelId()));
        car.setPlate(createCarRequest.getPlate());
        car.setState(createCarRequest.getState());
        car.setDailyPrice(createCarRequest.getDailyPrice());
        car.setModelYear(createCarRequest.getModelYear());

        carRepository.save(car);

        CreatedCarResponse response = new CreatedCarResponse();
        response.setId(car.getId());
        response.setModelYear(car.getModelYear());
        response.setPlate(car.getPlate());
        response.setState(car.getState());
        response.setDailyPrice(car.getDailyPrice());
        response.setModelId(car.getModel().getId());
        response.setCreatedDate(car.getCreatedDate());

        return response;


    }

    @Override
    public UpdatedCarResponse update(UpdateCarRequest updateCarRequest) {
        Car car = carRepository.findById(updateCarRequest.getId()).orElseThrow(() -> new IllegalArgumentException("Car not found"));
        car.setModel(modelService.getByModelId(updateCarRequest.getModelId()));
        car.setPlate(updateCarRequest.getPlate());
        car.setState(updateCarRequest.getState());
        car.setDailyPrice(updateCarRequest.getDailyPrice());
        car.setModelYear(updateCarRequest.getModelYear());
        carRepository.save(car);

        UpdatedCarResponse response = new UpdatedCarResponse();
        response.setId(car.getId());
        response.setModelYear(car.getModelYear());
        response.setPlate(car.getPlate());
        response.setState(car.getState());
        response.setDailyPrice(car.getDailyPrice());
        response.setModelId(car.getModel().getId());
        response.setUpdatedDate(car.getUpdatedDate());

        return response;

    }

    @Override
    public GetCarResponse getById(int id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Car not found"));
        GetCarResponse response = new GetCarResponse();
        response.setId(car.getId());
        response.setModelYear(car.getModelYear());
        response.setPlate(car.getPlate());
        response.setState(car.getState());
        response.setDailyPrice(car.getDailyPrice());
        response.setModelId(car.getModel().getId());
        return response;
    }

    @Override
    public List<GetCarListResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        List<GetCarListResponse> response = cars.stream().map(car -> new GetCarListResponse(car.getId(),car.getModelYear(), car.getPlate(),   car.getState(), car.getDailyPrice(), car.getModel().getId())).toList();
        return response;
    }

    @Override
    public void delete(int id) {

        carRepository.deleteById(id);

    }
}
