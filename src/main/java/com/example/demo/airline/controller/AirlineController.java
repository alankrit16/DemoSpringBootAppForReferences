package com.example.demo.airline.controller;

import com.example.demo.airline.entity.Flights;
import com.example.demo.airline.service.FlightService;
import com.example.demo.airline.service.FlightServiceImpl;
import com.mongodb.MongoWriteException;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
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
            response.put("created",true);
            response.put("flight",flights.getFlightName());
            return new ResponseEntity(response,HttpStatus.CREATED);
        }catch (MongoWriteException mongoWriteException){
            Map<String,Object> error = new LinkedHashMap<>();
            error.put("error",mongoWriteException.getError());
            error.put("status",HttpStatus.ALREADY_REPORTED.value());
            return new ResponseEntity(error, HttpStatus.ALREADY_REPORTED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @PostMapping("/saveManyFlights")
    public ResponseEntity<?> saveManyFlights(@RequestBody List<Flights> flights){
        try{
            this.flightService.saveManyFlights(flights);
            Map<String,Object> response = new LinkedHashMap<>();
            response.put("created",true);
            for (int i=1;i<=flights.size();i++) {
                response.put("flight "+i,flights.get(i-1).getFlightName());
            }
            return new ResponseEntity(response,HttpStatus.CREATED);
        }catch (MongoWriteException mongoWriteException){
            Map<String,Object> error = new LinkedHashMap<>();
            error.put("error",mongoWriteException.getError());
            error.put("status",HttpStatus.ALREADY_REPORTED.value());
            return new ResponseEntity(error, HttpStatus.ALREADY_REPORTED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllFlights")
    public ResponseEntity<?> getAllFlights(){
        try{
            List<Flights> allFlights = this.flightService.getAllFlights();
            return new ResponseEntity(allFlights,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getFlightById/{uid}")
    public ResponseEntity<?> getFlightById(@PathVariable Integer uid) {
        return new ResponseEntity(this.flightService.getFlightById(uid),HttpStatus.OK);
    }

}
