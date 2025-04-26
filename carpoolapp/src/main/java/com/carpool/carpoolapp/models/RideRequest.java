package com.carpool.carpoolapp.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RideRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User rider;
    private double sourceLat, sourceLng, destLat, destLng;
    private LocalDateTime time;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getRider() {
		return rider;
	}
	public void setRider(User rider) {
		this.rider = rider;
	}
	public double getSourceLat() {
		return sourceLat;
	}
	public void setSourceLat(double sourceLat) {
		this.sourceLat = sourceLat;
	}
	public double getSourceLng() {
		return sourceLng;
	}
	public void setSourceLng(double sourceLng) {
		this.sourceLng = sourceLng;
	}
	public double getDestLat() {
		return destLat;
	}
	public void setDestLat(double destLat) {
		this.destLat = destLat;
	}
	public double getDestLng() {
		return destLng;
	}
	public void setDestLng(double destLng) {
		this.destLng = destLng;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
    
    
}
