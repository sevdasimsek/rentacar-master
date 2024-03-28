package com.etiya.rentacar.entities;

import com.etiya.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Cars")
public class Car extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "rentalBranchId")
    private RentalBranch rentalBranch;

    @ManyToOne()
    @JoinColumn(name = "model_id")
    private Model model;

    @Column(name = "modelYear")
    private int modelYear;

    @Column(name = "plate")
    private String plate;

    @Column(name = "state")//1-Available 2-Rented 3-Under Maintenance
    private int state;

    @Column(name = "dailyPrice")
    private double dailyPrice;

    @Column(name = "kilometer")
    private double kilometer;

}