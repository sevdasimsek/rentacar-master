package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.car.CreateCarRequest;
import com.etiya.rentacar.business.dtos.requests.car.UpdateCarRequest;
import com.etiya.rentacar.business.dtos.responses.car.CreatedCarResponse;
import com.etiya.rentacar.business.dtos.responses.car.GetCarListResponse;
import com.etiya.rentacar.business.dtos.responses.car.GetCarResponse;
import com.etiya.rentacar.business.dtos.responses.car.UpdatedCarResponse;
import com.etiya.rentacar.entities.Car;

import java.util.List;

public interface CarService {
    CreatedCarResponse add(CreateCarRequest createCarRequest);

    UpdatedCarResponse update(UpdateCarRequest updateCarRequest);

    GetCarResponse getById(int id);

    List<GetCarListResponse> getAll();

    void delete(int id);

    public Car findById (int id);

    public void updateCarState(int carId, int state);

    public void updateCarRentalBranchId(int carId, int rentalBranchId);

    public void updateCarKilometer(int carId, int kilometer);

}
