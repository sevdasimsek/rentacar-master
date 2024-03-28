package com.etiya.rentacar.dataAccess.abstracts;

import com.etiya.rentacar.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository  extends JpaRepository<Rental, Integer> {
}
