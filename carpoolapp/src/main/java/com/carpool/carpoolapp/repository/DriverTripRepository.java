package com.carpool.carpoolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carpool.carpoolapp.models.DriverTrip;

public interface DriverTripRepository extends JpaRepository<DriverTrip, Long> {

}
