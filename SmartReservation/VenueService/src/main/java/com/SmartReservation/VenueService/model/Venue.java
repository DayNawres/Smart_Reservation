package com.SmartReservation.VenueService.model;

import com.datastax.oss.driver.api.mapper.annotations.ClusteringColumn;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import org.springframework.data.cassandra.core.mapping.Table;



import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(keyspace = "my_keyspace", name = "venue")
public class Venue {

    @PartitionKey
    private String category;
    @ClusteringColumn
    private String venueId;

    private String address;
    private List<String> amenities;
    private String availability;
    private int capacity;
    private String city;
    private String country;
    private LocalDateTime createdAt;
    private String cuisineType;
    private String description;
    private String email;
    private List<String> images;
    private String location;
    private List<String> menuItems;
    private String name;
    private int numberOfRooms;
    private String phone;
    private List<String> prices;
    private float rating;
    private List<String> roomTypes;
    private String sportType;
    private String state;
    private LocalDateTime updatedAt;
    private String username;

}
