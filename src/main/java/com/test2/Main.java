package com.test2;

import com.test2.app.RideSharingApp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        RideSharingApp app = new RideSharingApp();

        app.addUser("Rohan", 'M', 36);
        app.addVehicle("Rohan", "Swift", "KA-01-12345");

        app.addUser("Shashank", 'M', 29);
        app.addVehicle("Shashank", "Baleno", "TS-05-62395");

        app.addUser("Nandini", 'F', 29);
        app.addUser("Shipra", 'F', 27);
        app.addVehicle("Shipra", "Polo", "KA-05-41491");
        app.addVehicle("Shipra", "Activa", "KA-12-12332");

        app.addUser("Gaurav", 'M', 29);
        app.addUser("Rahul", 'M', 35);
        app.addVehicle("Rahul", "XUV", "KA-05-1234");

        // Offer rides
        app.offerRide("Rohan", "KA-01-12345", "Hyderabad", "Bangalore", 1);
        app.offerRide("Shipra", "KA-12-12332", "Bangalore", "Mysore", 1);
        app.offerRide("Shipra", "KA-05-41491", "Bangalore", "Mysore", 2);
        app.offerRide("Shashank", "TS-05-62395", "Hyderabad", "Bangalore", 2);
        app.offerRide("Rahul", "KA-05-1234", "Hyderabad", "Bangalore", 5);

        // Select rides
        app.selectRide("Nandini", "Bangalore", "Mysore", 1, "Most Vacant");
        app.selectRide("Gaurav", "Bangalore", "Mysore", 1, "Preferred Vehicle=Activa");

        // Print ride stats
        app.printRideStats();

    }
}