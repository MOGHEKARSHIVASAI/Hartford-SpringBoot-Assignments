package org.hartford.springbootproject1.service;

import org.hartford.springbootproject1.dao.FlightDao;
import org.hartford.springbootproject1.model.Flight;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{
    private FlightDao dao;

     public FlightServiceImpl(FlightDao dao) {
        this.dao = dao;
    }

    @Override
    public Flight save(Flight flight) {
        return dao.save(flight);
    }

    @Override
    public boolean deleteById(int id) {
        return dao.deleteById(id);
    }

    @Override
    public List<Flight> findAll() {
        return dao.findAll();
    }

    @Override
    public Flight findById(int id) {
        return dao.findById(id);
    }

    @Override
    public Flight update(int id, Flight flight) {
        return dao.update(id, flight);
    }

    @Override
    public List<Flight> findBySourceAndDestinationDepartureDate(String source, String destination, String departureDate) {
        return dao.findBySourceAndDestinationDepartureDate(source, destination, departureDate);
    }

    @Override
    public List<Flight> sortByDepartureTime(String source, String destination, String departureDate) {
        return dao.sortByDepartureTime(source, destination, departureDate);}
}
