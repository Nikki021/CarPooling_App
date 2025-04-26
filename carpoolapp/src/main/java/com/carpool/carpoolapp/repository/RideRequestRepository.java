package com.carpool.carpoolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carpool.carpoolapp.models.RideRequest;

public interface RideRequestRepository extends JpaRepository<RideRequest, Long>{

}
