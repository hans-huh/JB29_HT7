package by.ld.hw.ooptasks.task3.logic;

import java.util.Scanner;

public class TrainEditorLogic {
    public String getString(){
        String answer;
        Scanner scanner;
        scanner = new Scanner(System.in);

        System.out.print("> ");
        answer = scanner.nextLine().toLowerCase();
        System.out.println();

        return answer;
    }

    public static int getNumber(){
        int n;
        Scanner scanner;
        boolean isDigit;
        boolean meetCondition;

        n = 0;
        scanner = new Scanner(System.in);
        do{
            System.out.print("> ");
            isDigit = false;
            while (!isDigit){
                try{
                    n = scanner.nextInt();
                    isDigit = true;
                    System.out.println();
                } catch (java.util.InputMismatchException e){
                    System.out.println("Please enter a digit!");
                    scanner.next();
                    System.out.println();
                }
            }
            if(n < 0){
                System.out.println("You cannot enter a negative value. Please try again!");
                meetCondition = false;
            } else {
                meetCondition = true;
            }
            System.out.println();
        } while (!meetCondition);

        return n;
    }
}
