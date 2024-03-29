package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.CarService;
import com.etiya.rentacar.business.abstracts.CustomerService;
import com.etiya.rentacar.business.abstracts.RentalService;
import com.etiya.rentacar.business.dtos.requests.rental.CreateRentalRequest;
import com.etiya.rentacar.business.dtos.requests.rental.UpdateRentalRequest;
import com.etiya.rentacar.business.dtos.responses.rental.*;
import com.etiya.rentacar.core.exceptions.types.BusinessException;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.RentalRepository;
import com.etiya.rentacar.entities.Car;
import com.etiya.rentacar.entities.Customer;
import com.etiya.rentacar.entities.Rental;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
    private RentalRepository rentalRepository;
    private ModelMapperService modelMapperService;
    private CarService carService;
    private CustomerService customerService;

    @Override
    public CreatedRentalResponse add(CreateRentalRequest createRentalRequest) {
        // checkIfCarState(createRentalRequest.getCarId());
        Car car = carService.findById(createRentalRequest.getCarId());
        Customer customer = customerService.findById(createRentalRequest.getCustomerId());
        customer.setId(createRentalRequest.getCustomerId());
        Rental mappedRental = new Rental();
        mappedRental.setCar(car);
        mappedRental.setCustomer(customer);
        mappedRental.setRentStartDate(createRentalRequest.getRentStartDate());
        mappedRental.setRentEndDate(createRentalRequest.getRentEndDate());
        mappedRental.setRentStartKilometer(car.getKilometer());
        carService.updateCarState(car.getId(), 2);


        Rental createdRental = rentalRepository.save(mappedRental);

        return modelMapperService.forResponse().map(createdRental, CreatedRentalResponse.class);
    }

    @Override
    public UpdatedRentalResponse update(UpdateRentalRequest updateRentalRequest) {
        Rental rental = findById(updateRentalRequest.getId());
        //Car car = carService.findById(updateRentalRequest.getCarId());
        Rental mappedRental = new Rental();
        mappedRental.setId(rental.getId());
        mappedRental.setCreatedDate(rental.getCreatedDate());
        mappedRental.setCar(rental.getCar());
        mappedRental.setCustomer(rental.getCustomer());
        mappedRental.setRentStartKilometer(rental.getRentStartKilometer());
        mappedRental.setRentStartDate(rental.getRentStartDate());
        mappedRental.setRentEndDate(rental.getRentEndDate());
        mappedRental.setUpdatedDate(LocalDateTime.now());
        mappedRental.setReturnDate(updateRentalRequest.getReturnDate());
        mappedRental.setRentEndKilometer(updateRentalRequest.getRentEndKilometer());
        carService.updateCarKilometer(rental.getCar().getId(), updateRentalRequest.getRentEndKilometer());
        //carService.updateCarRentalBranchId(rental.getCar().getId() ,updateRentalRequest.getRentalBranchId());

        Rental savedRental = rentalRepository.save(mappedRental);
        return modelMapperService.forResponse().map(savedRental, UpdatedRentalResponse.class);

    }

    @Override
    public List<GetRentalListResponse> getAll() {
        List<Rental> rentals = rentalRepository.findAll();
        return rentals.stream().filter(rental -> rental.getDeletedDate() == null).map(rental -> modelMapperService.forResponse().map(rental, GetRentalListResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetRentalResponse getById(int id) {
        Rental rental = findById(id);
        return modelMapperService.forResponse().map(rental, GetRentalResponse.class);
    }


    @Override
    public DeletedRentalResponse delete(int id) {
        Rental rental = findById(id);
        rental.setDeletedDate(LocalDateTime.now());
        rentalRepository.save(rental);
        return modelMapperService.forResponse().map(rental, DeletedRentalResponse.class);
    }

    public Rental findById(int id) {
        //  carBusinessRules.carIdIsExist(id);
        return rentalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Rental not found"));
    }

    public void checkIfCarState(int carId) {
        Car response = carService.findById(carId);
        if (response.getState() == 2)
            throw new BusinessException("This vehicle has been rented before.Rental status is passive");
//Arabanın statei 2 ise bana hata fırlatsın.
        //Business katmanına taşıcaksın.
    }
}
