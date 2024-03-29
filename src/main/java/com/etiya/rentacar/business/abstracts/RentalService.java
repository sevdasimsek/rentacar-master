package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.rental.CreateRentalRequest;
import com.etiya.rentacar.business.dtos.requests.rental.UpdateRentalRequest;
import com.etiya.rentacar.business.dtos.responses.rental.*;

import java.util.List;

public interface RentalService {
    CreatedRentalResponse add(CreateRentalRequest createRentalRequest);

    UpdatedRentalResponse update(UpdateRentalRequest updateRentalRequest);

    List<GetRentalListResponse> getAll();

    GetRentalResponse getById(int id);

    public DeletedRentalResponse delete(int id);

    //public Rental findById(int id);
    public void checkIfCarState(int carId);
}
