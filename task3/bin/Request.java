package by.ld.hw.ooptasks.task3.bin;

public class Request {
    public boolean isRailroadElectrified() {
        return isRailroadElectrified;
    }

    public void setRailroadElectrified(boolean railroadElectrified) {
        isRailroadElectrified = railroadElectrified;
    }

    private boolean isRailroadElectrified;
    private int desiredSpeed; // (km / h)
    private int numberOfPassengers;
    private int weightOfCargo; // in tons
    private boolean isCargo;
    private boolean isPassenger;

    public Request(){
        isRailroadElectrified = false;
        desiredSpeed = 0;
        numberOfPassengers = 0;
        weightOfCargo = 0;
        isCargo = false;
        isPassenger = false;
    }


    public int getDesiredSpeed() {
        return desiredSpeed;
    }

    public void setDesiredSpeed(int desiredSpeed) {
        this.desiredSpeed = desiredSpeed;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public int getWeightOfCargo() {
        return weightOfCargo;
    }

    public void setWeightOfCargo(int weightOfCargo) {
        this.weightOfCargo = weightOfCargo;
    }

    public boolean isCargo() {
        return isCargo;
    }

    public void setCargo(boolean cargo) {
        isCargo = cargo;
    }

    public boolean isPassenger() {
        return isPassenger;
    }

    public void setPassenger(boolean passenger) {
        isPassenger = passenger;
    }
}
