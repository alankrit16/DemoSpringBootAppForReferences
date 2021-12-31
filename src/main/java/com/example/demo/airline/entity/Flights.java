package com.example.demo.airline.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Document(collection = "Flights")
public class Flights {
    @Id
    private int UID;
    private String flightName;
    private String source;
    private String destination;
    private Map<String,Object> operations; //departure_time, arrival_time

}
