package com.example.demo.airline.repository;

import com.example.demo.airline.entity.Flights;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface FlightRepository {

    public void saveFlight(Flights flights);
//    public List<Flights> getAllFlights();
}
