package com.reservationapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bus {


     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int busId; // Primary Key

    private String busNumber;
    private String busType;
    private double price;
    private int totalSeats;
    private int availableSeats;

    @OneToOne(mappedBy = "bus")

    private Route route;

}
