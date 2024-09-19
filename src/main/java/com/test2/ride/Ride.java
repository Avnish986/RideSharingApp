package com.test2.ride;

import com.test2.user.User;
import com.test2.vehicle.Vehicle;

public class Ride {
    private User driver;
    private Vehicle vehicle;
    private String origin;
    private String destination;
    private int availableSeats;

    public Ride(User driver, Vehicle vehicle, String origin, String destination, int availableSeats) {
        this.driver = driver;
        this.vehicle = vehicle;
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }

    public void endRide() {
        this.availableSeats = 0;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
