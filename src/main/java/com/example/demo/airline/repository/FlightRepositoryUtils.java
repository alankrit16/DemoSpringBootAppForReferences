package com.example.demo.airline.repository;

import com.example.demo.airline.entity.Flights;
import org.bson.Document;

import java.util.HashMap;

public class FlightRepositoryUtils {

    public static Document mapFromFlightEntity(Flights flights){
            return new Document()
                .append("_id",flights.getUID())
                .append("flightName",flights.getFlightName())
                .append("source",flights.getSource())
                .append("destination",flights.getDestination())
                .append("operations",new Document()
                        .append("departure_time",flights.getOperations().get("departure_time"))
                        .append("arrival_time",flights.getOperations().get("arrival_time")));
    }

}
