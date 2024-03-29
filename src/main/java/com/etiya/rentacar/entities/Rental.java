package com.etiya.rentacar.entities;

import com.etiya.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "rentals")
public class Rental extends BaseEntity {

    @Column(name = "rentStartDate", nullable = false)
    private LocalDate rentStartDate;
    @Column(name = "rentEndDate", nullable = false)
    private LocalDate rentEndDate;
    @Column(name = "returnDate")
    private LocalDate returnDate;
    @Column(name = "rentStartKilometer", nullable = false)
    private int rentStartKilometer;
    @Column(name = "rentEndKilometer")
    private int rentEndKilometer;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;

}
