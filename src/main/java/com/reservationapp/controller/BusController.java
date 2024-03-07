package com.reservationapp.controller;

import com.reservationapp.payload.BusDto;
import com.reservationapp.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;


@RestController
@RequestMapping("/api/v1/bus")
public class BusController {

    @Autowired

    private BusService busService;

    @PostMapping("/add")
     public ResponseEntity<String> addBus(@RequestBody BusDto busDto) throws ParseException {



        busService.addBus(busDto);
        return new ResponseEntity<>("Bus details added", HttpStatus.CREATED);

    }



}
