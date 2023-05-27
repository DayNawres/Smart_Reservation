package com.smartreservation.ReservationService.Service;

import com.smartreservation.ReservationService.Model.Reservation;
import com.smartreservation.ReservationService.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class ReservationService {
    @Autowired


    ReservationRepository reservationRepository;
    //getting all Reservation record by using the method findaAll() of CrudRepository
    public List<Reservation> getAllReservation()
    {
        List<Reservation> reservation = new ArrayList<Reservation>();
        reservationRepository.findAll().forEach(Reservation1 -> reservation.add(Reservation1));
        return reservation;
    }
    //getting a specific record by using the method findById() of CrudRepository
    public Reservation getReservationById(long id)
    {
        return reservationRepository.findById(id).get();
    }
    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Reservation reservation)
    {
        reservationRepository.save(reservation);
    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(long id)
    {
        reservationRepository.deleteById(id);
    }
    //updating a record
    public void update(Reservation reservation, long id)
    {
        reservationRepository.save(reservation);
    }
}
