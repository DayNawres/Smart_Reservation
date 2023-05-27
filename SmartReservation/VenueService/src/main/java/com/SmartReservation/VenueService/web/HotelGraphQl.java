package com.SmartReservation.VenueService.web;

import com.SmartReservation.VenueService.Enum.CategoryEnum;
import com.SmartReservation.VenueService.Model.Hotel;
import com.SmartReservation.VenueService.Model.Restaurent;
import com.SmartReservation.VenueService.Model.Sportfacility;
import com.SmartReservation.VenueService.Model.Venue;
import com.SmartReservation.VenueService.Repository.VenueRepository;
import com.SmartReservation.VenueService.Service.CreateService;
//import graphql.kickstart.servlet.apollo.ApolloScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

@Controller
public class HotelGraphQl {
    @Autowired
    VenueRepository venueRepository;
    CreateService service;
//    @Bean
//    public GraphQLScalarType uploadScalar() {
//        return ApolloScalars.Upload; // name: Upload
//    }
    @MutationMapping
    public String addHotel(@Argument(name = "hotel") Hotel hotel )
    {
        Venue venue = new Venue();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        venue.setCategory(CategoryEnum.Hotel);
        venue.setVenueId(UUID.randomUUID().toString());
        venue.setAddress(hotel.address);
        venue.setAmenities(hotel.amenities);
        venue.setCapacity(hotel.capacity);
        venue.setCity(hotel.city);
        venue.setCountry(hotel.country);
        venue.setCreated_at( LocalDateTime.now());
        venue.setUpdated_at( LocalDateTime.now());
        venue.setEmail(hotel.email);
        venue.setDescription(hotel.description);
        venue.setImages(hotel.images);
        venue.setLocation(hotel.location);
        venue.setName(hotel.name);
        venue.setNumber_of_Rooms(hotel.numberOfRooms);
        venue.setPhone(hotel.phone);
        venue.setPrices(hotel.prices);
        venue.setRating(hotel.rating);
        venue.setRoom_types(hotel.roomTypes);
        venue.setState(hotel.state);
        venue.setUsername(hotel.username);

        Venue savedJohn = venueRepository.save(venue);

        return "hhhhhh"; }
    @MutationMapping
    public String addRestaurent(@Argument(name="restaurent") Restaurent restaurent)
    {
        Venue venue = new Venue();
        venue.setCuisine_type(restaurent.cuisine_type);
        venue.setMenuesitems(restaurent.menuesitems);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        venue.setCategory(CategoryEnum.Restaurent);
        venue.setVenueId(UUID.randomUUID().toString());
        venue.setAddress(restaurent.address);
        venue.setAmenities(restaurent.amenities);
        venue.setCapacity(restaurent.capacity);
        venue.setCity(restaurent.city);
        venue.setCountry(restaurent.country);
        venue.setCreated_at( LocalDateTime.now());
        venue.setUpdated_at( LocalDateTime.now());
        venue.setEmail(restaurent.email);
        venue.setDescription(restaurent.description);
        venue.setMenuesitems(restaurent.menuesitems);

        venue.setImages(restaurent.images);
        venue.setLocation(restaurent.location);
        venue.setName(restaurent.name);
        venue.setPhone(restaurent.phone);
        venue.setPrices(restaurent.prices);
        venue.setRating(restaurent.rating);
        venue.setState(restaurent.state);
        venue.setUsername(restaurent.username);

        Venue savedJohn = venueRepository.save(venue);

        return "hhhhhh"; }
    @MutationMapping
    public String addSportfacility(@Argument(name="sportfacility") Sportfacility sportfacility)
    {
        Venue venue = new Venue();
        venue.setSport_type(sportfacility.sport_type);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        venue.setCategory(CategoryEnum.SportFacility);
        venue.setVenueId(UUID.randomUUID().toString());
        venue.setAddress(sportfacility.address);
        venue.setAmenities(sportfacility.amenities);
        venue.setCapacity(sportfacility.capacity);
        venue.setCity(sportfacility.city);
        venue.setCountry(sportfacility.country);
        venue.setCreated_at( LocalDateTime.now());
        venue.setUpdated_at( LocalDateTime.now());
        venue.setEmail(sportfacility.email);
        venue.setDescription(sportfacility.description);

        venue.setImages(sportfacility.images);
        venue.setLocation(sportfacility.location);
        venue.setName(sportfacility.name);
        venue.setPhone(sportfacility.phone);
        venue.setPrices(sportfacility.prices);
        venue.setRating(sportfacility.rating);
        venue.setState(sportfacility.state);
        venue.setUsername(sportfacility.username);

        Venue savedJohn = venueRepository.save(venue);

        return "hhhhhh"; }


    @MutationMapping
    public String updateHotel(@Argument String id,@Argument(name="hotel") Hotel hotel)
    {

        Optional<Venue> venueData=venueRepository.findByVenueId(id);
        if (venueData.isPresent())
        {Venue venue=venueData.get();
        venue.setAddress(hotel.address);
        venue.setAmenities(hotel.amenities);
        venue.setCapacity(hotel.capacity);
        venue.setCity(hotel.city);
        venue.setCountry(hotel.country);

        venue.setEmail(hotel.email);
        venue.setDescription(hotel.description);

            venue.setImages(hotel.images);
        venue.setLocation(hotel.location);
        venue.setName(hotel.name);
        venue.setNumber_of_Rooms(hotel.numberOfRooms);
        venue.setPhone(hotel.phone);
        venue.setPrices(hotel.prices);
        venue.setRating(hotel.rating);
        venue.setRoom_types(hotel.roomTypes);
        venue.setState(hotel.state);
        venue.setUsername(hotel.username);
            Venue savedJohn = venueRepository.save(venue);}



        return "updated"; }
    @MutationMapping
    public String updateRestaurent(@Argument String id,@Argument(name="restaurent") Restaurent restaurent)
    {

        Optional<Venue> venueData=venueRepository.findByVenueId(id);
        if (venueData.isPresent())
        {Venue venue=venueData.get();
            venue.setCuisine_type(restaurent.cuisine_type);
            venue.setMenuesitems(restaurent.menuesitems);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            venue.setCategory(CategoryEnum.Restaurent);
            venue.setVenueId(UUID.randomUUID().toString());
            venue.setAddress(restaurent.address);
            venue.setAmenities(restaurent.amenities);
            venue.setCapacity(restaurent.capacity);
            venue.setCity(restaurent.city);
            venue.setCountry(restaurent.country);
            venue.setCreated_at( LocalDateTime.now());
            venue.setUpdated_at( LocalDateTime.now());
            venue.setEmail(restaurent.email);
            venue.setDescription(restaurent.description);
            venue.setMenuesitems(restaurent.menuesitems);
            venue.setImages(restaurent.images);
            venue.setLocation(restaurent.location);
            venue.setName(restaurent.name);
            venue.setPhone(restaurent.phone);
            venue.setPrices(restaurent.prices);
            venue.setRating(restaurent.rating);
            venue.setState(restaurent.state);
            venue.setUsername(restaurent.username);
            Venue savedJohn = venueRepository.save(venue);}



        return "updated"; }
    @MutationMapping
    public String updateSportFacilty(@Argument String id,@Argument(name = "sportFacility") Sportfacility sportfacility)
    {

        Optional<Venue> venueData=venueRepository.findByVenueId(id);
        if (venueData.isPresent())
        {Venue venue=venueData.get();
            venue.setSport_type(sportfacility.sport_type);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            venue.setCategory(CategoryEnum.SportFacility);
            venue.setVenueId(UUID.randomUUID().toString());
            venue.setAddress(sportfacility.address);
            venue.setAmenities(sportfacility.amenities);
            venue.setCapacity(sportfacility.capacity);
            venue.setCity(sportfacility.city);
            venue.setCountry(sportfacility.country);
            venue.setCreated_at( LocalDateTime.now());
            venue.setUpdated_at( LocalDateTime.now());
            venue.setEmail(sportfacility.email);
            venue.setDescription(sportfacility.description);
            List<String> files = new ArrayList<String>();

            venue.setImages(sportfacility.images);
            venue.setLocation(sportfacility.location);
            venue.setName(sportfacility.name);
            venue.setPhone(sportfacility.phone);
            venue.setPrices(sportfacility.prices);
            venue.setRating(sportfacility.rating);
            venue.setState(sportfacility.state);
            venue.setUsername(sportfacility.username);




            Venue savedJohn = venueRepository.save(venue);}



        return "updated"; }
    @QueryMapping
    public List<Venue> ShowHotel()
    {
        return  venueRepository.findAllByCategory("Hotel");
    }
    @QueryMapping
    public List<Venue> ShowRestaurent()
    {
        return  venueRepository.findAllByCategory("Restaurent");
    }
    @QueryMapping
    public List<Venue> ShowSportFacility()
    {
        return  venueRepository.findAllByCategory("SportFacility");
    }
    @QueryMapping
    public List<Venue> ShowUserHotel(@Argument String username)
    {
        return  venueRepository.findAllByUsernameAndCategory(username,"Hotel");
    }
    @QueryMapping
    public List<Venue> ShowUserRestaurent(@Argument String username)
    {
        return  venueRepository.findAllByUsernameAndCategory(username,"Hotel");
    }
    @QueryMapping
    public List<Venue> ShowUserSportFacility(@Argument String username)
    {
        return  venueRepository.findAllByUsernameAndCategory(username,"Hotel");
    }

    @MutationMapping
    public String delete(@Argument String id)
    {
        venueRepository.deleteById(id);
        return "Delete";
    }

}
