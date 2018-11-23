/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vehicletester;

public class Vehicle {
    public double gasKilometrage;
    public double fuelTankSize;
    public double fuelAvailable;
    public double kilometresTravelled;
    public int passengers;
    public double passengerFare;
    public double fuelCost;

    public Vehicle() {
        //Default Constructor
        gasKilometrage = 0;
        fuelTankSize = 0;
        fuelAvailable = 0;
        kilometresTravelled = 0;
        passengers = 0;
        passengerFare = 25.00;
        fuelCost = 1.05;
    }

    public Vehicle(double gK, double fTS, double fA, double kT, int pP, double pF, double fC){
        gasKilometrage = gK;
        fuelTankSize = fTS;
        fuelAvailable = fA;
        kilometresTravelled = kT;
        passengers = pP;
        passengerFare = pF;
        fuelCost = fC;
    }

    public void addFuel(double gas){
        if((fuelTankSize - fuelAvailable) >= gas){
            fuelAvailable += gas;
            System.out.println("Added " + gas + "L of gas to the tank.");
        }
        else {
            System.out.println("You tried to add " + gas + "L of gas.");
            System.out.println("There is only room for " + (fuelTankSize - fuelAvailable) + "L.");
        }
    }

    public void driveVehicle(double kms){
        //Drive the vehicle
        //ex.  If the vehicle uses 9.5L/100 km then
        //     litresNeeded = kms * 9.5 / 100
        System.out.println("Drive " + kms + "kms.  Start with " + fuelAvailable + "L of gas.");
        double litresNeeded = (kms * gasKilometrage) / 100.0;
        if(fuelAvailable >= litresNeeded){
            fuelAvailable -= litresNeeded;
            kilometresTravelled += kms;
            System.out.println("Used " + litresNeeded + "L of gas.");
        }
        else {
            System.out.println("Ran out of fuel!");
            //Calculate how many kms were driven
            double kmsThisDrive = (fuelAvailable * 100.0) / gasKilometrage;
            kilometresTravelled += kmsThisDrive;
            fuelAvailable = 0;
            System.out.println("The vehicle drove " + kmsThisDrive + " before running out of gas.");
        }
    }

    public String toString() {
        String output = "Gas Kilometrage = " + gasKilometrage + "\n";
        output += "Fuel Tank Size = " + fuelTankSize + "\n";
        output += "Fuel Available = " + fuelAvailable + "\n";
        output += "Kilometres Driven = " + kilometresTravelled + "\n";
        output += "Passengers Present = " + passengers + "\n";
        output += "Passenger Fare = $" + passengerFare + "\n";
        output += "Fuel Cost per Litre = $" + fuelCost + "/L\n";
        output += "-------------------------------------\n";
        output += "Revenue Generated = $" + passengerFare * passengers + "\n";
        output += "Cost of the Journey = $" + fuelCost * kilometresTravelled * gasKilometrage + "\n";
        output += "Profit gained = $" + ((passengerFare * passengers) - (fuelCost * kilometresTravelled * gasKilometrage)) + "\n";
        return output;
    }
}
