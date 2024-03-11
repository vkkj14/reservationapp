package com.reservationapp.controller;

import com.reservationapp.entity.Route;
import com.reservationapp.payload.BusDto;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.RouteRepository;
import com.reservationapp.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;


@RestController
@RequestMapping("/api/v1/bus")
public class BusController {
    @Autowired
    private BusService busService;
//  @Autowired
//   private BusRepository busRepository;
    @Autowired
    private RouteRepository routeRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addBus(@RequestBody BusDto busDto) throws ParseException {

        busService.addBus(busDto);
        return new ResponseEntity<>("Bus details added", HttpStatus.CREATED);

    }

    
}