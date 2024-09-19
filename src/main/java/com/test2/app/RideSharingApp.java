package com.test2.app;

import com.test2.ride.Ride;
import com.test2.user.User;
import com.test2.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideSharingApp {

    private Map<String, User> users;
    private List<Ride> rides;

    public RideSharingApp() {
        this.users = new HashMap<>();
        this.rides = new ArrayList<>();
    }

    public void addUser(String name, char gender, int age) {
        User user = new User(name, gender, age);
        users.put(name, user);
    }

    // Add a vehicle to a user
    public void addVehicle(String userName, String model, String number) {
        User user = users.get(userName);
        if (user != null) {
            Vehicle vehicle = new Vehicle(userName, model, number);
            user.addVehicle(vehicle);
        }
    }

    // Offer a ride
    public void offerRide(String userName, String vehicleNumber, String origin, String destination, int availableSeats) {
        User user = users.get(userName);
        if (user != null) {
            Vehicle vehicle = findVehicleByNumber(user.getVehicles(), vehicleNumber);
            if (vehicle != null && canOfferRide(vehicle)) {
                Ride ride = new Ride(user, vehicle, origin, destination, availableSeats);
                user.offerRide(ride);
                rides.add(ride);
            } else {
                System.out.println("Cannot offer ride with this vehicle");
            }
        }
    }

    // Select a ride based on strategy
    public void selectRide(String userName, String origin, String destination, int seats, String selectionStrategy) {
        User user = users.get(userName);
        if (user != null) {
            List<Ride> availableRides = findAvailableRides(origin, destination, seats);
            Ride selectedRide = null;

            if (selectionStrategy.equals("Most Vacant")) {
                selectedRide = findMostVacantRide(availableRides);
            } else if (selectionStrategy.contains("Preferred Vehicle")) {
                String preferredVehicle = selectionStrategy.split("=")[1];
                selectedRide = findPreferredVehicleRide(availableRides, preferredVehicle);
            }

            if (selectedRide != null) {
                selectedRide.endRide();
                user.takeRide(selectedRide);
                System.out.println("Ride selected: " + selectedRide.getVehicle().getModel());
            } else {
                System.out.println("No rides found");
            }
        }
    }

    // End a ride
    public void endRide(Ride ride) {
        ride.endRide();
    }

    // Print ride statistics
    public void printRideStats() {
        for (User user : users.values()) {
            System.out.println(user.getName() + ": " + user.getRidesTaken().size() + " Taken, " + user.getRidesOffered().size() + " Offered");
        }
    }

    // Helper methods

    private Vehicle findVehicleByNumber(List<Vehicle> vehicles, String number) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleNo().equals(number)) {
                return vehicle;
            }
        }
        return null;
    }


    private boolean canOfferRide(Vehicle vehicle) {
        for (Ride ride : rides) {
            if (ride.getVehicle().getVehicleNo().equals(vehicle.getVehicleNo()) && ride.getAvailableSeats() > 0) {
                return false; // There's already an active ride for this vehicle
            }
        }
        return true;
    }

    private List<Ride> findAvailableRides(String origin, String destination, int seats) {
        List<Ride> availableRides = new ArrayList<>();
        for (Ride ride : rides) {
            if (ride.getOrigin().equals(origin) && ride.getDestination().equals(destination) && ride.getAvailableSeats() >= seats) {
                availableRides.add(ride);
            }
        }
        return availableRides;
    }

    private Ride findMostVacantRide(List<Ride> availableRides) {
        if (availableRides.isEmpty()) {
            return null;
        }

        Ride mostVacantRide = availableRides.get(0);
        for (Ride ride : availableRides) {
            if (ride.getAvailableSeats() > mostVacantRide.getAvailableSeats()) {
                mostVacantRide = ride;
            }
        }
        return mostVacantRide;
    }

    private Ride findPreferredVehicleRide(List<Ride> availableRides, String preferredVehicle) {
        for (Ride ride : availableRides) {
            if (ride.getVehicle().getModel().equalsIgnoreCase(preferredVehicle)) {
                return ride;
            }
        }
        return null;
    }
}
