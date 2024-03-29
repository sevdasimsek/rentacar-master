package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.RentalService;
import com.etiya.rentacar.business.dtos.requests.rental.CreateRentalRequest;
import com.etiya.rentacar.business.dtos.responses.rental.CreatedRentalResponse;
import com.etiya.rentacar.entities.Car;

public class RentalManager  implements RentalService {
    @Override
    public CreatedRentalResponse add(CreateRentalRequest createRentalRequest) {
        Car car = new Car();
        return null;
    }
}
