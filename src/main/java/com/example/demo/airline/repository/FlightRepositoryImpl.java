package com.example.demo.airline.repository;

import com.example.demo.airline.entity.Flights;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
@Repository
public class FlightRepositoryImpl implements FlightRepository{

    @Autowired
    MongoTemplate mongo;
    MongoCollection collection;

    @Override
    public void saveFlight(Flights flights) {
        this.collection = mongo.getCollection("Flights");
        Document d = new Document()
                .append("_id",flights.getUID())
                .append("flightName",flights.getFlightName())
                .append("source",flights.getSource())
                .append("destination",flights.getDestination())
                .append("operations",new Document()
                        .append("departure_time",flights.getOperations().get("departure_time"))
                        .append("arrival_time",flights.getOperations().get("arrival_time")));
        collection.insertOne(d);

    }

//    @Override
//    public List<Flights> getAllFlights() {
//        return mongo.findAll(Flights.class);
//    }
}
