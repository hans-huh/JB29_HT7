package by.ld.hw.ooptasks.task3.bin;

import by.ld.hw.ooptasks.task3.bin.cars.Vehicle;
import by.ld.hw.ooptasks.task3.bin.locomotives.Locomotive;

import java.util.ArrayList;
import java.util.Objects;

public class Train {
    private static int idCounter = 1;
    private int trainID;
    private String type;
    private ArrayList<Locomotive> locomotives;
    private ArrayList<Vehicle> vehicles;

    public Train(String type, ArrayList<Locomotive> locomotives, ArrayList<Vehicle> vehicles){
        trainID = idCounter++;
        this.type = type;
        this.locomotives = locomotives;
        this.vehicles = vehicles;
    }

    public int getTrainID(){
        return trainID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Locomotive> getLocomotives() {
        return locomotives;
    }

    public void setLocomotives(ArrayList<Locomotive> locomotives) {
        this.locomotives = locomotives;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString(){
        return "Train #" + trainID + "; type: " + type + "; locomotive: " + locomotives.get(0).toString() + "; number of cars: " + vehicles.size();
    }

    @Override
    public int hashCode(){
        return Objects.hash(trainID, type, locomotives, vehicles);
    }

    @Override
    public boolean equals(Object otherObject){
        Train other;

        // test to see if the objects are identical
        if(this == otherObject) {
            return true;
        }

        // if otherObject is null returns false
        if(otherObject == null) {
            return false;
        }

        // if the classes do not match, they cannot be equal and false is returned
        if(this.getClass() != otherObject.getClass()){
            return false;
        }

        other = (Train) otherObject;

        return this.trainID == other.trainID;
    }
}
