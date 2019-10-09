package by.ld.hw.ooptasks.task3.bin.cars;

public class Vehicle {

    private static int carIdCounter = 1;
    private int vehicleID;
    private int leasePrice;

    public Vehicle() {
        this.vehicleID = carIdCounter++;
        leasePrice = 1000;
    }

    public int getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(int leasePrice) {
        this.leasePrice = leasePrice;
    }

    public int getVehicleID() {
        return vehicleID;
    }

}
