package by.ld.hw.ooptasks.task3.bin;

import by.ld.hw.ooptasks.task3.bin.cars.FreightCar;
import by.ld.hw.ooptasks.task3.bin.cars.PassengerCar;
import by.ld.hw.ooptasks.task3.bin.cars.Vehicle;
import by.ld.hw.ooptasks.task3.bin.locomotives.DieselTrain;
import by.ld.hw.ooptasks.task3.bin.locomotives.ElectricTrain;
import by.ld.hw.ooptasks.task3.bin.locomotives.Locomotive;
import by.ld.hw.ooptasks.task3.logic.TrainEditorLogic;

import java.util.ArrayList;

public class TrainAssembler {
    private static final String assemblerWelcomeMessage = "Welcome to the train assembler!";
    private final static String selectLocomotiveOption = "Would you prefer\n1. Electric Train. \n2. Diesel Train";
    private final static String selectLocomotivePrompt = "Please enter 1 (Electric Train) or 2 (Diesel Train).";

    private Request request;
    private String trainType;
    private ArrayList<Locomotive> locomotives;
    private ArrayList<Vehicle> cars;
    private Train train;

    public TrainAssembler(Request request){
        this.request = request;
        locomotives = new ArrayList<>();
        cars = new ArrayList<>();
    }

    public void trainAssemblerStart(){
        System.out.println("\n\n###########################################\n");
        System.out.println(assemblerWelcomeMessage);
        setTrainType();
        locomotives.add(selectLocomotiveType());

        // adding to our train the number of cars required to transport cargo / passengers
        for(int i = 0; i < getNumOfCars(); i++){
            if (request.isPassenger()) {
                cars.add(new PassengerCar());
            }

            if (request.isCargo()){
                cars.add(new FreightCar());
            }
        }

        // finally, creating the train
        train = new Train(trainType, locomotives, cars);
    }

    private void setTrainType(){
        if(request.isPassenger()){
            trainType = "Passenger Train";
        }

        if(request.isCargo()){
            trainType = "Cargo Train";
        }
    }


    private Locomotive selectLocomotiveType(){
        TrainEditorLogic trainEditorLogic;
        int option;
        Locomotive locomotive;

        locomotive = new Locomotive();
        if(request.isRailroadElectrified()){
            if(request.getDesiredSpeed() <= new DieselTrain().getSpeed()){
                 trainEditorLogic= new TrainEditorLogic();
                 option = 0;
                 while (option != 1 && option != 2){
                     System.out.println(selectLocomotiveOption);
                     option = trainEditorLogic.getNumber();
                     if(option == 1){
                         locomotive = new ElectricTrain();
                     } else if(option == 2){
                         locomotive =  new DieselTrain();
                     } else {
                         System.out.println(selectLocomotivePrompt);
                     }
                 }

            }
        } else {
            locomotive = new DieselTrain();
        }

        return locomotive;
    }


    private int getNumOfCars(){
        int load;
        int capacity;
        int carsInTotal;

        carsInTotal = 0;
        if(request.isCargo()){
            load = request.getWeightOfCargo();
            capacity = new FreightCar().getMaxLoad();
            carsInTotal = (int) Math.ceil((double)load / capacity);
        }

        if(request.isPassenger()){
            load = request.getNumberOfPassengers();
            capacity = new PassengerCar().getNumberOfPassengers();
            carsInTotal = (int) Math.ceil((double)load / capacity);
        }

        return carsInTotal;
    }


    public int getTotalPrice(){
        int locoPrice;
        int carsPrice;
        ArrayList<Locomotive> locos;
        ArrayList<Vehicle> cars;

        locoPrice = 0;
        carsPrice = 0;
        locos = train.getLocomotives();
        cars = train.getVehicles();

        for(int i = 0; i < locos.size(); i++){
            locoPrice += locos.get(i).getLeasePrice();
        }

        for(int i = 0; i < cars.size(); i++){
            carsPrice += cars.get(i).getLeasePrice();
        }

        return  carsPrice + locoPrice;


    }

    public String getTrain(){
        return train.toString();
    }


}
