package com.etiya.rentacar.entities;

import com.etiya.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    @Column(name = "modelYear")
    private int modelYear;
    @Column(name = "plate")
    private String plate;
    @Column(name = "state")//1-Available 2-Rented 3-Under Maintenance
    private int state;
    @Column(name = "dailyPrice")
    private double dailyPrice;
    @Column(name = "kilometer")
    private int kilometer;

    @ManyToOne()
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "rentalBranchId")
    private RentalBranch rentalBranch;

    @OneToMany(mappedBy = "car")
    private List<Rental> rentals;

}