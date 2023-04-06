package com.SmartReservation.VenueService.Model;

import lombok.Data;

import java.util.List;
@Data
public class Restaurent {
    public String address;
    public List<String> amenities;
    public int capacity;
    public String city;
    public String country;
    public String cuisine_type;
    public String description;
    public String email;
    public List<String> images;
    public String location;
    public List<String> menuesitems;
    public String name;
    public  String phone;
    public List<String> prices;
    public float rating;
    public String state;
    public String username;
}
