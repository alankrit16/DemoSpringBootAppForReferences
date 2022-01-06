package com.example.demo.airline.service;

import com.example.demo.airline.entity.Flights;
import com.example.demo.airline.repository.FlightRepositoryImpl;
import com.mongodb.MongoWriteException;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    FlightRepositoryImpl flightRepository;

    @Override
    public void saveFlight(Flights flights){
        try {
            this.flightRepository.saveFlight(flights);
        }catch (MongoWriteException mongoWriteException){
            throw mongoWriteException;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public void saveManyFlights(List<Flights> flights) {
        try {
            this.flightRepository.saveManyFlights(flights);
        }catch (MongoWriteException mongoWriteException){
            throw mongoWriteException;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Flights> getAllFlights() {
        try{
            List<Flights> flights = this.flightRepository.getAllFlights();
            return flights;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public Flights getFlightById(Integer uid) {
        return this.flightRepository.getFlightById(uid);
    }
}
