package com.example.demo.airline.service;

import com.example.demo.airline.entity.Flights;
import org.bson.Document;

import java.util.List;

public interface FlightService {

    void saveFlight(Flights flights);

    void saveManyFlights(List<Flights> flights);

    List<Flights> getAllFlights();

    Flights getFlightById(Integer uid);
}
