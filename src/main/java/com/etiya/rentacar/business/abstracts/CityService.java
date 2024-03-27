package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.city.CreateCityRequest;
import com.etiya.rentacar.business.dtos.requests.city.UpdateCityRequest;
import com.etiya.rentacar.business.dtos.responses.city.*;

import java.util.List;

public interface CityService {
    CreatedCityResponse add(CreateCityRequest createCityRequest);

    UpdatedCityResponse update(UpdateCityRequest updateCityRequest);

    List<GetCityListResponse> getAll();

    GetCityResponse getById(int id);

    DeletedCityResponse delete(int id);
}
