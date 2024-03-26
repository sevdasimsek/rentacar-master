package com.etiya.rentacar.dataAccess.abstracts;

import com.etiya.rentacar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    Optional<Brand> findByNameIgnoreCase (String brandName);
}

//select * from brands where lower(name) = lower('abc') Yukarıdaki kod arkaplanda bunn gibi bir sorgu oluşturuyorç
