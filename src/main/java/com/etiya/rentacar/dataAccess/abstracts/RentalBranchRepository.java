package com.etiya.rentacar.dataAccess.abstracts;

import com.etiya.rentacar.entities.RentalBranch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalBranchRepository extends JpaRepository<RentalBranch, Integer> {
}
