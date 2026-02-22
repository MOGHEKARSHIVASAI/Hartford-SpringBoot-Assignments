package org.hartford.springbootproject1.controller;

import org.hartford.springbootproject1.model.Flight;
import org.hartford.springbootproject1.service.FlightService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/flights")
public class FlightController {
    private FlightService service;
    public FlightController(FlightService service){
        this.service = service;
    }
    @PostMapping("/add")
    public Flight addFlight(@RequestBody Flight flight){
        return service.save(flight);
    }

    @DeleteMapping("/delete/{id}")
    public boolean removeFlight(@PathVariable int id){
        return service.deleteById(id);
    }


    @GetMapping
    public List<Flight> findAllFlights(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Flight findFlightById(@PathVariable int id){
        return service.findById(id);
    }

    @GetMapping("/search/{source}/{destination}/{departureDate}")
    public List<Flight> findBySourceAndDestinationDepartureDate(@PathVariable String source,@PathVariable String destination,@PathVariable String departureDate){
        return service.findBySourceAndDestinationDepartureDate(source, destination, departureDate);
    }


    @GetMapping("/search/sort/{source}/{destination}/{departureDate}")
    public List<Flight> sortByDepartureTime(@PathVariable String source,@PathVariable String destination,@PathVariable String departureDate){
        return service.sortByDepartureTime(source, destination, departureDate);
    }

    @PutMapping("/{id}")
    public Flight updateFlightById(@PathVariable int id,@RequestBody Flight flight){
        return service.update(id, flight);
    }


}
