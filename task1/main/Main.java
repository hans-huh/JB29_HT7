package by.ld.hw.ooptasks.task1.main;

import by.ld.hw.ooptasks.task1.bin.Text;
import by.ld.hw.ooptasks.task1.bin.TextEditor;

/**
 * Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести
 * на консоль текст, заголовок текста.
 */

public class Main {
    public static void main(String[] args) {
        Text myText;
        TextEditor myEditor;

        myEditor = new TextEditor();
        myEditor.start();

        myText = myEditor.getText();

    }
}
