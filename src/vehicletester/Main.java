package vehicletester;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        double gasPrice = Double.parseDouble(JOptionPane.showInputDialog("What is the price for gas in $/L"));
        int passengers = Integer.parseInt(JOptionPane.showInputDialog("How many passengers are being transported ? "));
        Vehicle car1 = new Vehicle(7.5, 60.0, 60.0, 0.0, passengers, 30.00, gasPrice);
        //Show Vehicle Info
        System.out.println(car1);

        //Drive car for 100km
        car1.driveVehicle(100.0);
        System.out.println(car1);

        //Drive car for 450 kms
        car1.driveVehicle(450.0);
        System.out.println(car1);

        //Try to drive 1000 km - runs out of gas
        car1.driveVehicle(1000.0);
        System.out.println(car1);

        //Add 25L of gas
        car1.addFuel(25.0);
        System.out.println(car1);

        //Try to add 100 L of gas
        car1.addFuel(100.0);
        System.out.println(car1);
    }
}
