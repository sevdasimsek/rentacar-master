package com.etiya.rentacar.entities;

import com.etiya.rentacar.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Brands")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Brand extends BaseEntity {


    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Model> models;

}
