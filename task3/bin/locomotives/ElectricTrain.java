package by.ld.hw.ooptasks.task3.bin.locomotives;

public class ElectricTrain extends Locomotive {
    private int speed;
    private double leaseCoefficient;
    private int lease;

    public ElectricTrain(){
        super();
        leaseCoefficient = 1.2;
        lease = (int) (super.getLeasePrice() * leaseCoefficient);
        speed = 120;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getLeaseCoefficient() {
        return leaseCoefficient;
    }

    public void setLeaseCoefficient(double leaseCoefficient) {
        this.leaseCoefficient = leaseCoefficient;
    }

    public int getLease() {
        return lease;
    }

    public void setLease(int lease) {
        this.lease = lease;
    }

    @Override
    public String toString(){
        return "Electric";
    }
}
