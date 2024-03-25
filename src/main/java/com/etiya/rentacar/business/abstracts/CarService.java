package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.car.CreateCarRequest;
import com.etiya.rentacar.business.dtos.requests.car.UpdateCarRequest;
import com.etiya.rentacar.business.dtos.responses.car.CreatedCarResponse;
import com.etiya.rentacar.business.dtos.responses.car.GetCarListResponse;
import com.etiya.rentacar.business.dtos.responses.car.GetCarResponse;
import com.etiya.rentacar.business.dtos.responses.car.UpdatedCarResponse;

import java.util.List;

public interface CarService {
    CreatedCarResponse add(CreateCarRequest createCarRequest);
    UpdatedCarResponse update(UpdateCarRequest updateCarRequest);

    GetCarResponse getById(int id);

    List<GetCarListResponse> getAll();

    void delete(int id);


}
