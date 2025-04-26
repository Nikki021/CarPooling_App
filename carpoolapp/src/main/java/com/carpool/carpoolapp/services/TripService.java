package com.carpool.carpoolapp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carpool.carpoolapp.models.DriverTrip;
import com.carpool.carpoolapp.models.RideRequest;
import com.carpool.carpoolapp.repository.DriverTripRepository;
import com.carpool.carpoolapp.repository.RideRequestRepository;

@Service
public class TripService {
	@Autowired
    private DriverTripRepository driverTripRepo;

    @Autowired
    private RideRequestRepository rideRequestRepo;

	private static final double MAX_DISTANCE_KM = 10.0;

	public List<DriverTrip> findMatchingTrips(Long requestId) {
		// TODO Auto-generated method stub
		
		RideRequest request = rideRequestRepo.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Ride request not found"));

        List<DriverTrip> allTrips = driverTripRepo.findAll();
        return allTrips.stream()
                .filter(trip -> isMatchingRoute(trip, request, MAX_DISTANCE_KM))
                .collect(Collectors.toList());
	}

	private boolean isMatchingRoute(DriverTrip trip, RideRequest request, double maxDistanceKm) {
		// TODO Auto-generated method stub
		double pickupDistance = distance(trip.getSourceLat(), trip.getSourceLng(),
                request.getSourceLat(), request.getSourceLng());

		double dropoffDistance = distance(trip.getDestLat(), trip.getDestLng(),
                request.getDestLat(), request.getDestLng());

		return pickupDistance <= maxDistanceKm && dropoffDistance <= maxDistanceKm;
	}

	private double distance(double sourceLat, double sourceLng, double sourceLat2, double sourceLng2) {
		// TODO Auto-generated method stub
		final int R = 6371; // Radius of the Earth in km
        double dLat = Math.toRadians(sourceLat2 - sourceLat);
        double dLon = Math.toRadians(sourceLng2 - sourceLng);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(sourceLat)) * Math.cos(Math.toRadians(sourceLat2)) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // Distance in km
	}

}
