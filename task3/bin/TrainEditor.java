package by.ld.hw.ooptasks.task3.bin;


import by.ld.hw.ooptasks.task3.logic.TrainEditorLogic;

import java.util.Scanner;

public class TrainEditor {
    private final static String programDescription = new String("\nThis program allows you to create your own train " +
            "based on your needs and budget.\nTo continue with the program, press 'y'. To exit the program, press 'n' \n");
    private final static String proceedWithProgramPrompt = new String("Proceed with the program? (y/n)\n");
    private final static String requestPrompt = new String("Thank you for choosing our console application! Let's create a request and assemble your train!\n");
    private final static String electrificationQuestion = new String("Is the railroad electrified?\n1. Electrified. \n2. Not Electrified");
    private final static String electrificationPrompt = new String("Please enter 1 (Electrified) or 2 (Not Electrified).");
    private final static String cargoOrPassenger = new String("Is this a cargo train or a passenger train?\n1. Cargo train. \n2. Passenger train.");
    private final static String cargoOrPassengerPrompt = new String("Please enter 1 (Cargo train) or 2 (Passenger train).");
    private final static String numberOfPassengersPrompt = new String("Please provide the planned number of your passengers.");
    private final static String weightOfCargoPrompt = new String("Please provide the planned weight of your cargo.");
    private final static String desiredSpeedPrompt = new String("What is the desired speed of your train?");
    private final static String submittedRequestMessage = new String("Your request has been submitted!");


    public TrainEditor(){
    }

    public void launch(){
        String answer;
        boolean answerFlag;
        TrainEditorLogic editorLogic;

        editorLogic = new TrainEditorLogic();
        System.out.println("### Welcome to Train Editor! ###");
        System.out.println("################################");
        System.out.println(programDescription);

        answerFlag = false;
        while(!answerFlag){
            System.out.println(proceedWithProgramPrompt);
            answer = editorLogic.getString();

            if(answer.equals("y")){
                answerFlag = true;
                start();
            }

            if(answer.equals("n")){
                answerFlag = true;
                exit();
            }
        }
    }

    public void start(){
        TrainEditorLogic editorLogic;
        TrainAssembler trainAssembler;
        int railroadElectrified;
        int trainType;
        int load;
        int speed;
        Request request;

        editorLogic = new TrainEditorLogic();

        System.out.println(requestPrompt);

        request = new Request();

        System.out.println(electrificationQuestion);
        railroadElectrified = 0;
        while(railroadElectrified != 1 && railroadElectrified != 2) {

            railroadElectrified = editorLogic.getNumber();

            if (railroadElectrified == 1) {
                request.setRailroadElectrified(true);
            } else if (railroadElectrified == 2) {
                request.setRailroadElectrified(false);
            } else {
                System.out.println(electrificationPrompt);
            }
        }


        trainType = 0;
        System.out.println(cargoOrPassenger);

        // Keeps looping until user selects either 1 (cargo train) or 2 (passenger train)
        while(trainType != 1 && trainType != 2){

            trainType = editorLogic.getNumber();

            if(trainType == 1){
                request.setCargo(true);
                request.setPassenger(false);
            } else if(trainType == 2) {
                request.setCargo(false);
                request.setPassenger(true);
            } else {
                System.out.println(cargoOrPassengerPrompt);
            }
        }

        if(request.isCargo()){
            System.out.println(weightOfCargoPrompt);
            load = editorLogic.getNumber();
            request.setWeightOfCargo(load);

        }

        if(request.isPassenger()){
            System.out.println(numberOfPassengersPrompt);
            load = editorLogic.getNumber();
            request.setNumberOfPassengers(load);
        }

        System.out.println(desiredSpeedPrompt);
        speed = editorLogic.getNumber();
        request.setDesiredSpeed(speed);

        trainAssembler = new TrainAssembler(request);
        System.out.println(submittedRequestMessage);
        trainAssembler.trainAssemblerStart();
        System.out.println("Here is your train: ");
        System.out.println(trainAssembler.getTrain());
        System.out.println("The total cost is $" + trainAssembler.getTotalPrice());

    }

    public void exit(){
        System.out.println("Bye.");
    }

}
