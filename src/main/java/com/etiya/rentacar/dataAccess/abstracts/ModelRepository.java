package com.etiya.rentacar.dataAccess.abstracts;

import com.etiya.rentacar.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}
