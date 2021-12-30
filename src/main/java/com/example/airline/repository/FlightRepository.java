package com.example.airline.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FlightRepository extends MongoRepository<String,Integer> {
}
