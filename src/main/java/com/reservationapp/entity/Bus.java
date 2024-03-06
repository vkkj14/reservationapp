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

    @Column(name="bus_number",unique = true)
    private String busNumber;
    private String busType;
    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String totalDuration;
    private String fromTime;
    private String toTime;
    private double price;
    private int totalSeats;
    private int availableSeats;

    @OneToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

}
