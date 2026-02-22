package org.hartford.jpademo.service;

import org.hartford.jpademo.entity.Flight;
import org.hartford.jpademo.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FlightService {
    @Autowired
    private FlightRepository repo;
    public Flight addFlight(Flight flight){
        return repo.save(flight);
    }
    public boolean deleteById(Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }
    public List<Flight> findAll(){
        return repo.findAll();
    }
    public Flight findById(Long id){
        return repo.findById(id).orElse(null);
    }

    public Flight update(Long id,Flight f){
        Flight flight= findById(id);
        if(flight!=null){
            flight.setSource(flight.getSource());
            flight.setDestination(flight.getDestination());
            flight.setDepartureTime(flight.getDepartureTime());
            flight.setDepartureDate(flight.getDepartureDate());
            repo.save(flight);
            return flight;
        }
     return null;
    }


}
