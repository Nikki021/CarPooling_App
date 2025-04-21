package controller;

import model.Ride;
import repository.RideRepository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rides")
public class RideController {
	@Autowired
    private RideRepository rideRepository;

    @PostMapping("/post")
    public Ride postRide(@RequestBody Ride ride) {
        return rideRepository.save(ride);
    }

    @GetMapping("/search")
    public List<Ride> searchRides(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String date // Expected format: YYYY-MM-DDTHH:mm
    ) {
        LocalDateTime queryTime = LocalDateTime.parse(date);
        return rideRepository.findByStartLocationAndDestinationAndDepartureTimeBetween(
                from, to, queryTime.minusHours(2), queryTime.plusHours(2));
    }
}
