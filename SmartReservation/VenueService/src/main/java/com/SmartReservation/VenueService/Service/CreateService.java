package com.SmartReservation.VenueService.Service;

import com.SmartReservation.VenueService.Enum.CategoryEnum;
import com.SmartReservation.VenueService.Model.Venue;
import com.SmartReservation.VenueService.Repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

public class CreateService {
    @Autowired
    VenueRepository venueRepository;
    @PostConstruct

    public String saveHotel(String address, List<String> amenities, int capacity, String city, String country, String description, String email, List<String> images, String location, String name, int numberOfRooms, String phone, List<String> prices, float rating, List<String> roomTypes, String state, String username){
        Venue venue = new Venue();
        venue.setCuisine_type("none");
        venue.setMenuesitems(List.of(new String[]{"none"}));
        venue.setSport_type("none");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        venue.setCategory(CategoryEnum.Hotel);
        venue.setVenueId(UUID.randomUUID().toString());
        venue.setAddress("address");
        venue.setAmenities(List.of(new String[]{"Ani", "Sam", " Joe"}));
        venue.setCapacity(5);
        venue.setCity("city");
        venue.setCountry("country");
        venue.setCreated_at( LocalDateTime.now());
        venue.setUpdated_at( LocalDateTime.now());
        venue.setEmail("email");
        venue.setDescription("description");
        venue.setMenuesitems(List.of(new String[]{"Ani", "Sam", " Joe"}));
        venue.setImages(List.of(new String[]{"Ani", "Sam", " Joe"}));
        venue.setLocation("location");
        venue.setName("hotel essada ");
        venue.setNumber_of_Rooms(5);
        venue.setPhone("phone");
        venue.setPrices(List.of(new String[]{"5.5", "6.5"}));
        venue.setRating(55);
        venue.setRoom_types(List.of(new String[]{"Ani", "Sam", " Joe"}));
        venue.setState("state");
        venue.setUsername("username");

        Venue savedJohn = venueRepository.save(venue);

return venue.getName()+"created succesfully";
    }
}
