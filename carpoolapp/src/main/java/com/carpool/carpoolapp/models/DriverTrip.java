package com.carpool.carpoolapp.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DriverTrip {
	@Id @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User driver;
    private double sourceLat, sourceLng, destLat, destLng;
    private LocalDateTime time;
    private int seatsAvailable;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getDriver() {
		return driver;
	}
	public void setDriver(User driver) {
		this.driver = driver;
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
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
    
}
