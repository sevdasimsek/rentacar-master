package com.etiya.rentacar.core.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "createdDate")
    private LocalDateTime createdDate;

    @Column(name = "updatedDate")
    private LocalDateTime updatedDate;

    @Column(name = "deletedDate")
    private LocalDateTime deletedDate;

    @PrePersist
    private void beforeAdd(){
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    private void beforeUpdate(){
        updatedDate = LocalDateTime.now();
    }

    @PreRemove
    private void beforeDelete(){
        deletedDate = LocalDateTime.now();
    }

}
