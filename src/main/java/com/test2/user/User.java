package com.test2.user;

import com.test2.ride.Ride;
import com.test2.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    char gender;
    int age;
    List<Vehicle> vehicles;
    private List<Ride> ridesOffered;
    private List<Ride> ridesTaken;

    public User(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.vehicles = new ArrayList<>();
        this.ridesOffered = new ArrayList<>();
        this.ridesTaken = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void offerRide(Ride ride) {
        ridesOffered.add(ride);
    }

    public void takeRide(Ride ride) {
        ridesTaken.add(ride);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Ride> getRidesOffered() {
        return ridesOffered;
    }

    public void setRidesOffered(List<Ride> ridesOffered) {
        this.ridesOffered = ridesOffered;
    }

    public List<Ride> getRidesTaken() {
        return ridesTaken;
    }

    public void setRidesTaken(List<Ride> ridesTaken) {
        this.ridesTaken = ridesTaken;
    }
}
