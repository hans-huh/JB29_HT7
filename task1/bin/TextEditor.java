package by.ld.hw.ooptasks.task1.bin;

import by.ld.hw.ooptasks.task1.logic.TextEditorLogic;

import java.util.Scanner;

public class TextEditor {// эм, вот ты представь объект этого класса - это винегрет получается
    // ты просто объединил в одном классе поля, потому что 'так легче'
    // но этот класс станет (и уже стал) неподдерживаемым
    private Text text;
    private TextEditorLogic textEditorLogic;
    private String userInput;
    private boolean flag;
    private Scanner scanner;


    private final static String EXIT_EDITOR_KEYS = ":q";
    private final static String ADD_SENTENCE_TO_SPECIFIC_PLACE_KEYS = ":as";
    private final static String DELETE_SENTENCE_KEYS = ":ds";
    private final static String EDIT_SENTENCE_KEYS = ":es";
    private final static String ADD_TITLE_KEYS = ":at";
    private final static String EDIT_TITLE_KEYS = ":et";
    private final static String DELETE_TITLE_KEYS = ":dt";
    private final static String PRINT_TEXT_KEYS = ":print";
    private final static String GET_HELP_KEYS = ":h";

    public TextEditor(){
        scanner = new Scanner(System.in);
        text = new Text();
        textEditorLogic = new TextEditorLogic();
    }

    public Text getText(){
        return text;
    }

    public void start(){
        System.out.println("========== WELCOME TO THE TEXT EDITOR! ==========");
        System.out.println("START TYPING TO CREATE YOUR NEW TEXT OR USE ONE OF THE FOLLOWING COMMANDS:");
        printHelp();

        flag = true;
        while(flag){
            System.out.print("> ");
            userInput = scanner.nextLine();

            switch (userInput.toLowerCase()){
                case(EXIT_EDITOR_KEYS): {
                    System.out.println("Bye.");
                    flag = false;
                    break;
                }
                case(DELETE_SENTENCE_KEYS): {
                    textEditorLogic.deleteSentenceMethod(text);
                    break;
                }
                case(ADD_SENTENCE_TO_SPECIFIC_PLACE_KEYS):{
                    textEditorLogic.addSentenceToSpecificPlaceMethod(text);
                    break;
                }
                case(EDIT_SENTENCE_KEYS): {
                    textEditorLogic.editSentenceMethod(text);
                    break;
                }
                case (ADD_TITLE_KEYS): {
                    textEditorLogic.addTitleMethod(text);
                    break;
                }
                case (EDIT_TITLE_KEYS): {
                    textEditorLogic.editTitleMethod(text);
                    break;
                }
                case(DELETE_TITLE_KEYS): {
                    textEditorLogic.deleteTitleMethod(text);
                    break;
                }
                case (PRINT_TEXT_KEYS): {
                    textEditorLogic.printTextMethod(text);
                    System.out.println("\n");
                    break;
                }
                case(GET_HELP_KEYS): {
                    printHelp();
                    System.out.println();
                    break;
                }
                default: {
                    textEditorLogic.addSentenceMethod(text, userInput);
                }
            }
        }

    }

    public void printHelp(){
        System.out.println("Press " + EXIT_EDITOR_KEYS + " to exit the editor");
        System.out.println("Press " + ADD_SENTENCE_TO_SPECIFIC_PLACE_KEYS + " to add a sentence to a specific place");
        System.out.println("Press " + DELETE_SENTENCE_KEYS + " to delete a specific sentence");
        System.out.println("Press " + EDIT_SENTENCE_KEYS + " to edit a specific sentence");
        System.out.println("Press " + ADD_TITLE_KEYS + " to add the title");
        System.out.println("Press " + EDIT_TITLE_KEYS + " to edit the title");
        System.out.println("Press " + DELETE_TITLE_KEYS + " to delete the title");
        System.out.println("Press " + PRINT_TEXT_KEYS + " to print the text");
        System.out.println("Press " + GET_HELP_KEYS + " to display help\n");
    }


}
