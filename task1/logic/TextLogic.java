package by.ld.hw.ooptasks.task1.logic;

import by.ld.hw.ooptasks.task1.bin.Sentence;
import by.ld.hw.ooptasks.task1.bin.Text;

import java.util.ArrayList;

/**
 * Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести
 * на консоль текст, заголовок текста.
 */

public class TextLogic {

    public TextLogic(){

    }

    public void printTitle(Text text){
        System.out.println(text.getTitle());
    }

    public void printText(Text text){
        System.out.print("Title:  ");
        printTitle(text);
        System.out.println();

        ArrayList<Sentence> list;
        int length;

        list = text.getText();
        length = list.size();

        for(int i = 0; i < length; i++){
            System.out.print(list.get(i).toString());
        }

    }


    public void addSentence(Text text, Sentence... sentences) {
        for(int i = 0; i < sentences.length; i++){
            text.getText().add(sentences[i]);
        }
    }

    public void addSentence(Text text, int position,  Sentence[] sentences){
        if(position <= 0){
            position = 1;
        }
        for(int i = 0; i < sentences.length; i++){
            text.getText().add(position - 1 + i, sentences[i]);
        }
    }

    public void deleteSentence(Text text, int position){
        if(position <= 0){
            position = 1;
        }
        text.getText().remove(position - 1);
    }

    public void changeSentence(Text text, int position, Sentence... sentences ){
        if(position <= 0){
            position = 1;
        }

        for(int i = 0; i < sentences.length; i++){
            if(i != 0){
                text.getText().add(position - 1 + i, sentences[i]);
            } else {
                text.getText().set(position - 1, sentences[i]);
            }
        }

    }


}
