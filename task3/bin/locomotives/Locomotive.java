package by.ld.hw.ooptasks.task3.bin.locomotives;

public class Locomotive {
    private int leasePrice;
    private static int locomotiveIdCounter = 1;
    private int locoID;

    public Locomotive(){
        locoID = locomotiveIdCounter++;
        leasePrice = 5000;
    }

    public int getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(int leasePrice) {
        this.leasePrice = leasePrice;
    }

    @Override
    public String toString(){
        return "";
    }

}
