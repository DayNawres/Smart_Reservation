package com.smartreservation.ReservationService.Repository;

import com.smartreservation.ReservationService.Model.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    @Override
    Optional<Reservation> findById(Long aLong);
    Optional<Reservation> findAllBy();

    @Override
    void deleteById(Long aLong);


}
