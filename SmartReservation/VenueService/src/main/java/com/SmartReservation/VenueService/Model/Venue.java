package com.SmartReservation.VenueService.Model;


import java.time.LocalDateTime;
import java.util.List;

import com.SmartReservation.VenueService.Enum.CategoryEnum;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Table
    public class Venue {


    @PrimaryKeyColumn(
            name = "category", type = PrimaryKeyType.PARTITIONED)
     private CategoryEnum category;
    @PrimaryKeyColumn(
            name = "venue_id",
            ordinal = 2,
            type = PrimaryKeyType.CLUSTERED,
            ordering = Ordering.ASCENDING)
        private String venueId;
    @Column
    private String address;
    @Column
    private List<String> amenities;
    @Column
    private String availibility;
    @Column
    private int capacity;
    @Column
    private String city;
    @Column
        private String country;
    @Column
    private LocalDateTime created_at;
    @Column
    private String cuisine_type;
    @Column
    private String description;
    @Column
        private String email;
    @Column
    private List<String> images;
    @Column
    private String location;

    @Column
        private List<String> menuesitems;
    @Column
        private String name;
    @Column
        private int number_of_Rooms;
    @Column
        private String phone;
    @Column
        private List<String> prices;
    @Column
        private float rating;
    @Column
        private List<String> room_types;
    @Column
        private String sport_type;
    @Column
    private String state;
    @Column
    private LocalDateTime updated_at;
    @Column
        private String username;

        // getters and setters


    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public String getAvailibility() {
        return availibility;
    }

    public void setAvailibility(String availibility) {
        this.availibility = availibility;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getMenuesitems() {
        return menuesitems;
    }

    public void setMenuesitems(List<String> menuesitems) {
        this.menuesitems = menuesitems;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getCreate_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime createdAt) {
        this.created_at = createdAt;
    }

    public String getCuisine_type() {
        return cuisine_type;
    }

    public void setCuisine_type(String cuisine_type) {
        this.cuisine_type = cuisine_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber_of_Rooms() {
        return number_of_Rooms;
    }

    public void setNumber_of_Rooms(int number_of_Rooms) {
        this.number_of_Rooms = number_of_Rooms;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getPrices() {
        return prices;
    }

    public void setPrices(List<String> prices) {
        this.prices = prices;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<String> getRoom_types() {
        return room_types;
    }

    public void setRoom_types(List<String> room_types) {
        this.room_types = room_types;
    }

    public String getSport_type() {
        return sport_type;
    }

    public void setSport_type(String spor_type) {
        this.sport_type = spor_type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updatedAt) {
        this.updated_at = updatedAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


