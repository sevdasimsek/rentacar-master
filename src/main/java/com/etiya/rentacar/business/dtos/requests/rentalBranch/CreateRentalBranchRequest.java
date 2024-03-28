package com.etiya.rentacar.business.dtos.requests.rentalBranch;


import com.etiya.rentacar.entities.Car;
import com.etiya.rentacar.entities.City;
import com.etiya.rentacar.entities.Rental;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateRentalBranchRequest {

    private int id;
    private String name;

    private City city;

    private List<Car> cars;

    private List<Rental> rentals;
}
