package com.etiya.rentacar.dataAccess.abstracts;

import com.etiya.rentacar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
