package com.smartreservation.ReservationService.Controller;

import com.smartreservation.ReservationService.Model.Reservation;
import com.smartreservation.ReservationService.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ReservationController {
    //autowire the ReservationService class
    @Autowired
    ReservationService reservationService;
    //creating a get mapping that retrieves all the reservation detail from the database
    @GetMapping("/reservation")
    private List<Reservation> getAllReservation()
    {
        return reservationService.getAllReservation();
    }
    //creating a get mapping that retrieves the detail of a specific reservation
    @GetMapping("/reservation/{reservationid}")
    private Reservation getReservation(@PathVariable("reservationid") long reservationid)
    {
        return reservationService.getReservationById(reservationid);
    }
    //creating a delete mapping that deletes a specified reservation
    @DeleteMapping("/reservation/{id}")
    private void deleteBook(@PathVariable("reservationid") long id)
    {
        reservationService.delete(id);
    }
    //creating post mapping that post the reservation detail in the database
    @PostMapping("/reservation")
    private Reservation saveBook(@RequestBody Reservation reservation)
    {
        reservationService.saveOrUpdate(reservation);
        return reservation;
    }
    //creating put mapping that updates the reservation detail
    @PutMapping("/reservation")
    private Reservation update(@RequestBody Reservation reservation)
    {
        reservationService.saveOrUpdate(reservation);
        return reservation;
    }

}
