package com.test2.vehicle;

import com.test2.user.User;

public class Vehicle {
    String owner;
    String model;
    String vehicleNo;

    public Vehicle(String owner, String model, String vehicleNo) {
        this.owner = owner;
        this.model = model;
        this.vehicleNo = vehicleNo;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }
}
