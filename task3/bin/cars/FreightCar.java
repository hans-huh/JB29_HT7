package by.ld.hw.ooptasks.task3.bin.cars;

import java.util.Objects;

public class FreightCar extends Vehicle {
    private int maxLoad;  // in tons
    private double leaseCoefficient;
    private int lease;

    public FreightCar() {
        this.maxLoad = 50;
        leaseCoefficient = 0.7;
        lease = (int) (super.getLeasePrice() * leaseCoefficient);
    }

    public int getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }

    @Override
    public String toString(){
        return "Freight car, maxLoad(in tons): " + maxLoad;
    }

    @Override
    public int hashCode(){
        return Objects.hash(maxLoad);
    }

}
