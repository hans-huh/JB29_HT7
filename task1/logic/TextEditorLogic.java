package by.ld.hw.ooptasks.task1.logic;

import by.ld.hw.ooptasks.task1.bin.Sentence;
import by.ld.hw.ooptasks.task1.bin.Text;
import by.ld.hw.ooptasks.task1.bin.Word;

import java.util.Scanner;

public class TextEditorLogic {

    private TextLogic textLogic;
    private Scanner scanner;

    public TextEditorLogic(){
        scanner = new Scanner(System.in);
        textLogic = new TextLogic();
    }

    public void addSentenceToSpecificPlaceMethod(Text text){
        int sentenceNumber;
        Sentence[] input;

        if(checkNotEmpty(text)){
            System.out.println("Please enter the number of a sentence before which you want to insert new sentence: ");
            System.out.print("> ");
            sentenceNumber = getNumber();

            System.out.println("Please enter the new sentence: ");
            System.out.print("> ");
            input = getInput();

            textLogic.addSentence(text, sentenceNumber, input);
            System.out.println();
        } else {
            System.out.println("You have no sentences in your text. There is nothing to edit!");
        }
    }

    public void deleteSentenceMethod(Text text){
        int sentenceNumber;

        if (checkNotEmpty(text)) {
            System.out.println("Please enter the number of a sentence that you want to delete: ");
            System.out.print("> ");
            sentenceNumber = getNumber();

            textLogic.deleteSentence(text, sentenceNumber);
            System.out.println();
        } else {
            System.out.println("You have no sentences in your text. There is nothing to delete!");
        }
    }

    public void editSentenceMethod(Text text){
        Sentence[] input;
        int sentenceNumber;

        if(checkNotEmpty(text)){
            System.out.println("Please enter the number of a sentence that you want to edit: ");
            System.out.print("> ");
            sentenceNumber = getNumber();

            System.out.println("Please enter the new sentence: ");
            System.out.print("> ");
            input = getInput();

            textLogic.changeSentence(text, sentenceNumber, input);
            System.out.println();
        } else {
            System.out.println("You have no sentences in your text. There is nothing to edit!");
        }

    }

    public void addSentenceMethod(Text text, String userInput){
        Sentence[] input;

        input = getInput(userInput);
        textLogic.addSentence(text, input);
    }

    public void addTitleMethod(Text text){
        String title;

        System.out.println("Please enter the title: ");
        title = scanner.nextLine();

        text.setTitle(title);
        System.out.println("The title has been added! Please keep writing your text or select any of the editor's option");
    }

    public void editTitleMethod(Text text){
        String title;

        System.out.println("Please enter the new title: ");
        title = scanner.nextLine();

        text.setTitle(title);
        System.out.println("The title has been edited! Please keep writing your text or select any of the editor's option");
    }

    public void deleteTitleMethod(Text text){
        text.setTitle("");
        System.out.println("The title has been deleted! Please keep writing your text or select any of the editor's option");
    }

    public void printTextMethod(Text text){
        textLogic.printText(text);
    }

    private int getNumber(){
        int n;
        boolean meetCondition;
        boolean isDigit;

        n = 0;
        do{
            isDigit = false;
            while(!isDigit){
                try {
                    n = scanner.nextInt();
                    scanner.nextLine();
                    isDigit = true;
                }
                catch (java.util.InputMismatchException e){
                    System.out.println("Please enter a digit!");
                    scanner.next();
                }
            }

            if(n < 1) {
                System.out.println("Incorrect value. The number should be greater than zero! Try again...");
                meetCondition = false;
            } else {
                meetCondition = true;
            }

        } while(!meetCondition);

        return n;
    }

    private boolean checkNotEmpty(Text text){
        int totalSentences;

        totalSentences = text.getText().size();
        if(totalSentences > 0){
            return true;
        } else {
            return false;
        }
    }

    private Sentence[] getInput(){

        Sentence[] sentences;
        Word[] words;
        String input;
        String[] strSentences;
        String[] strWords;

        input = scanner.nextLine();

        // parsing phrases (delimited by dot(.)
        strSentences = input.split("\\.");
        sentences = new Sentence[strSentences.length];

        for(int i = 0; i < sentences.length; i++){
            // remove leading and trailing spaces
            strSentences[i] = strSentences[i].trim();

            // parsing words (delimited by whitespace(s)
            strWords = strSentences[i].split("\\s+");
            words = new Word[strWords.length];

            for(int j = 0; j < words.length; j++){
                words[j] = new Word(strWords[j]);
            }
            sentences[i] = new Sentence(words);
        }

        return sentences;
    }

    private Sentence[] getInput(String input){

        Sentence[] sentences;
        Word[] words;
        String[] strSentences;
        String[] strWords;

        // parsing phrases (delimited by dot(.)
        strSentences = input.split("\\.");
        sentences = new Sentence[strSentences.length];



        for(int i = 0; i < sentences.length; i++){
            // remove leading and trailing spaces
            strSentences[i] = strSentences[i].trim();

            // parsing words (delimited by whitespace(s)
            strWords = strSentences[i].split("\\s+");
            words = new Word[strWords.length];

            for(int j = 0; j < words.length; j++){
                words[j] = new Word(strWords[j]);
            }
            sentences[i] = new Sentence(words);
        }

        return sentences;
    }


}
