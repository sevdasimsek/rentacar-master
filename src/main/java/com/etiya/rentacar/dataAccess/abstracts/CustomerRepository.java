package com.etiya.rentacar.dataAccess.abstracts;

import com.etiya.rentacar.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
