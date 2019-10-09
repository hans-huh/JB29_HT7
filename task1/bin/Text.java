package by.ld.hw.ooptasks.task1.bin;

import java.util.ArrayList;

/**
 * Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести
 * на консоль текст, заголовок текста.
 */

public class Text {
    private String title;
    private ArrayList<Sentence> text;


    public Text(){
        title = "";
        text = new ArrayList<>();
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Sentence> getText() {
        return text;
    }


}
