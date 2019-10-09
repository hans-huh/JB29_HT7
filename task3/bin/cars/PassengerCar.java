package by.ld.hw.ooptasks.task3.bin.cars;

import java.util.Objects;

public class PassengerCar extends Vehicle {

    private int numberOfPassengers;
    private double leaseCoefficient;
    private int lease;

    public PassengerCar(){
        this.numberOfPassengers = 60;
        leaseCoefficient = 0.9;
        lease = (int) (super.getLeasePrice() * leaseCoefficient);
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public String toString(){
        return "Passenger car, number of passengers: " + numberOfPassengers;
    }

    @Override
    public int hashCode(){
        return Objects.hash(numberOfPassengers);
    }
}
