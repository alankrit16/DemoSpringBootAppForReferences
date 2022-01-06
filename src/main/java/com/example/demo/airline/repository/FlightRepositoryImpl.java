package com.example.demo.airline.repository;

import com.example.demo.airline.entity.Flights;
import com.mongodb.MongoWriteException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndUpdateOptions.*;
import com.mongodb.client.model.Updates;
import org.bson.BsonDocument;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Aggregates.set;
import static com.mongodb.client.model.Updates.combine;

@Repository
public class FlightRepositoryImpl implements FlightRepository{

    @Autowired
    MongoTemplate mongo;
    MongoCollection collection;


    @Override
    public void saveFlight(Flights flights){
        try {
            this.collection = mongo.getCollection("Flights");
            Document d = FlightRepositoryUtils.mapFromFlightEntity(flights);
            collection.insertOne(d);
        }catch (MongoWriteException writeException){
            writeException.printStackTrace();
            throw writeException;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }

    public void saveManyFlights(List<Flights> flights) {
        try {
            this.collection = mongo.getCollection("Flights");
            List<Document> flightDocuments = new ArrayList<>();
            for (Flights flight: flights) {
                Document flightDoc = FlightRepositoryUtils.mapFromFlightEntity(flight);
                flightDocuments.add(flightDoc);
            }
            collection.insertMany(flightDocuments);
        }catch (MongoWriteException writeException){
            writeException.printStackTrace();
            throw writeException;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Flights> getAllFlights() {
        try {
            this.collection = mongo.getCollection("Flights");
//            this.collection.updateMany(Filters.eq("source", "Allahabad"),
//                    combine(Updates.set("source", "Prayagraj")));
            return mongo.findAll(Flights.class);
        }catch (Exception e){
            throw e;
        }
    }
}
