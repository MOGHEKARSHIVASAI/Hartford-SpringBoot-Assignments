package org.hartford.springbootproject1.dao;

import org.hartford.springbootproject1.model.Flight;

import java.util.List;

public interface FlightDao {
    Flight save(Flight flight);
    boolean deleteById(int id);
    List<Flight> findAll();
    Flight findById(int id);
    Flight update(int id, Flight flight);
    List<Flight> findBySourceAndDestinationDepartureDate(String source, String destination,String departureDate);
    List<Flight> sortByDepartureTime(String source, String destination,String departureDate);

}
