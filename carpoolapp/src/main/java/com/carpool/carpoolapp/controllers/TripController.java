package com.carpool.carpoolapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carpool.carpoolapp.models.DriverTrip;
import com.carpool.carpoolapp.services.TripService;

@RestController
@RequestMapping("/api/trips")
public class TripController {
	@Autowired private TripService tripService;
	
	@GetMapping("/match/{requestId}")
    public List<DriverTrip> getMatches(@PathVariable Long requestId) {
        return tripService.findMatchingTrips(requestId);
    }
}
