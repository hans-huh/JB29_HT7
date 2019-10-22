package by.ld.hw.ooptasks.task3.bin.locomotives;// и вот сколько раз я говорила, что не именуются пакеты множественным числом

public class DieselTrain extends Locomotive {
    private int speed;
    private double leaseCoefficient;
    private int lease;

    public DieselTrain(){
        super();
        leaseCoefficient = 0.9;
        lease = (int) (super.getLeasePrice() * leaseCoefficient);
        speed = 100;
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
        return "Diesel";
    }
}
