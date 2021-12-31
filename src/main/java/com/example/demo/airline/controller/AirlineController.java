package com.example.demo.airline.controller;

import com.example.demo.airline.entity.Flights;
import com.example.demo.airline.service.FlightService;
import com.example.demo.airline.service.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
@ResponseBody
public class AirlineController {

    @Autowired
    FlightServiceImpl flightService;

    @PostMapping("/saveFlight")
    public ResponseEntity<?> saveFlight(@RequestBody Flights flights){
        try{
            this.flightService.saveFlight(flights);
            Map<String,Object> response = new LinkedHashMap<>();
            response.put("Created",true);
            response.put("Flight",flights.getFlightName());
            return new ResponseEntity(response,HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
