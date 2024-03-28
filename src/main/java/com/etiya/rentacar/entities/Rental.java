package com.etiya.rentacar.entities;

import com.etiya.rentacar.core.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Rentals")
public class Rental extends BaseEntity {

    private Car car;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    private LocalDate rentStartDate;

    private LocalDate rentEndDate;

    private LocalDate returnDate;

    private int rentStartKilometer;

    private int rentEndKilometer;

}
