package org.hartford.springbootproject1.dao;

import org.hartford.springbootproject1.model.Flight;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class FlightDaoImpl implements FlightDao{
    List<Flight> flights=new ArrayList<>();
    @Override
    public Flight save(Flight flight) {
        flights.add(flight);
        return flight;
    }

    @Override
    public boolean deleteById(int id) {
        Iterator<Flight> it=flights.iterator();
        while (it.hasNext()) {
            Flight f=it.next();
            if (f.getId()==id) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Flight> findAll() {
        return flights;
    }

    @Override
    public Flight findById(int id) {
        for(Flight f:flights){
            if(f.getId()==id){
                return f;
            }
        }
        return null;
    }

    @Override
    public Flight update(int id, Flight flight) {
        for(Flight f:flights){
            if(f.getId()==id){
                f.setFlightName(flight.getFlightName());
                f.setSource(flight.getSource());
                f.setDestination(flight.getDestination());
                f.setDepartureTime(flight.getDepartureTime());
                f.setDepartureDate(flight.getDepartureDate());
                return f;
            }

        }
        return null;
    }

    @Override
    public List<Flight> findBySourceAndDestinationDepartureDate(String source, String destination,String departureDate) {
       List<Flight> res=new ArrayList<>();
       for(Flight f:flights){
           if(f.getSource().equalsIgnoreCase(source) && f.getDestination().equalsIgnoreCase(destination) && f.getDepartureDate().equalsIgnoreCase(departureDate)){
                res.add(f);
           }
       }
         return res;
    }

    @Override
    public List<Flight> sortByDepartureTime(String source, String destination,String departureDate){
        List<Flight> res=findBySourceAndDestinationDepartureDate(source, destination, departureDate);
        res.sort((f1,f2)->f1.getDepartureTime().compareTo(f2.getDepartureTime()));
        return res;
    }
}
