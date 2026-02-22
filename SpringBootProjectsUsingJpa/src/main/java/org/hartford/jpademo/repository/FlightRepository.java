package org.hartford.jpademo.repository;

import org.hartford.jpademo.entity.Flight;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findBySourceAndDestinationAndDepartureDate(String source, String destination, Date departureDate);
}
