package com.example.demo.airline.service;

import com.example.demo.airline.entity.Flights;
import com.example.demo.airline.repository.FlightRepository;
import com.example.demo.airline.repository.FlightRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    FlightRepositoryImpl flightRepository;

    @Override
    public void saveFlight(Flights flights) {
        this.flightRepository.saveFlight(flights);

    }
}
