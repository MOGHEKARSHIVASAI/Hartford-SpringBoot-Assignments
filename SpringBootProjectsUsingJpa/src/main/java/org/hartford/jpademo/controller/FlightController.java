package org.hartford.jpademo.controller;


import org.hartford.jpademo.entity.Flight;
import org.hartford.jpademo.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")

public class FlightController {
    private FlightService service;
    public FlightController(FlightService service){
        this.service=service;
    }

    @PostMapping()
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
        return ResponseEntity.status(201).body(service.addFlight(flight));
    }

    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable Long id){
        return service.findById(id);
    }
    @GetMapping
    public List<Flight> getAllFlights(){
        return service.findAll();
    }
        @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFlightById(@PathVariable Long id){
        if(service.deleteById(id)){
                return ResponseEntity.status(204).build();
            }
            return ResponseEntity.status(404).build();
        }
        @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id,@RequestBody Flight flight){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, flight));
        }




}
