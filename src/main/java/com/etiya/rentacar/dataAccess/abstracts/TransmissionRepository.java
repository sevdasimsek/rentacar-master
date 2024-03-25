package com.etiya.rentacar.dataAccess.abstracts;

import com.etiya.rentacar.entities.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransmissionRepository extends JpaRepository<Transmission, Integer> {
}
