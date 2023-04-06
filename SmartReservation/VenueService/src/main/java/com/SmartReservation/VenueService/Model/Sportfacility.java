package com.SmartReservation.VenueService.Model;

import lombok.Data;

import java.util.List;
@Data
public class Sportfacility {
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
    public  String phone;
    public List<String> prices;
    public float rating;
    public String sport_type;
    public String state;
    public String username;
}
