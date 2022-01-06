package com.example.demo.airline.repository;

import com.example.demo.airline.entity.Flights;
import org.bson.Document;

import java.util.List;
public interface FlightRepository {

    void saveFlight(Flights flights);
    void saveManyFlights(List<Flights> flights);
    List<Flights> getAllFlights();
}
