package com.SmartReservation.VenueService.Model;

import lombok.Data;
import org.apache.pulsar.shade.org.glassfish.jersey.media.multipart.MultiPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class Hotel {
    public String address;
    public List<String> amenities;
    public int capacity;
    public String city;
    public String country;
    public String description;
    public String email;

    public List<String> images;

    public String location;
    public String name;
    public int numberOfRooms;
    public  String phone;
    public List<String> prices;
    public float rating;
    public List<String> roomTypes;
    public String state;
    public String username;

}
