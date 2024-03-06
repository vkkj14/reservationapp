package com.reservationapp.payload;

import com.reservationapp.entity.Driver;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
@Data
public class BusDto {
    private int busId; // Primary Key
    private String busNumber;
    private String busType;
    private String fromLocation;
    private String toLocation;
    private String  fromDate;
    private String toDate;
    private String totalDuration;
    private String fromTime;
    private String toTime;
    private double price;
    private int totalSeats;
    private int availableSeats;
    private Driver driver;
}
