package com.etiya.rentacar.dataAccess.abstracts;

import com.etiya.rentacar.entities.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelRepository extends JpaRepository<Fuel, Integer> {
}
