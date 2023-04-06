package com.SmartReservation.VenueService.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.SmartReservation.VenueService.Model.Venue;
import org.hibernate.sql.Select;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public interface VenueRepository extends CassandraRepository<Venue, String> {
    @Query(value = "select * from venue where venue_id = ?0 ALLOW FILTERING")
    Optional<Venue> findByVenueId(String id);
    @Query(value="Select * from venue where category=?0")
    List<Venue> findAllByCategory(String Category);

    @Override
    @Query("DELETE FROM venue WHERE venue_id = ?0 and category in ('Hotel', 'Restaurent','SportFacility')")
    void deleteById(String id);


    @Query("SELECT * FROM venue WHERE username=?0 AND category=?1 ALLOW FILTERING")
    List<Venue> findAllByUsernameAndCategory(String s,String b);
}
