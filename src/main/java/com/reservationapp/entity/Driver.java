package com.reservationapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;  // You may want to include an ID for database purposes

    private String name;
    private String licenseNumber;
    private  String addNumber;
    private String address;
    private String contactNumber;
    private String alternateContactNumber;
    private String emailId;
}
