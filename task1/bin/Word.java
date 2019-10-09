package by.ld.hw.ooptasks.task1.bin;

import java.util.Objects;

public class Word {

    private StringBuilder word;
    private int wordID;
    private static int idCounter = 1;

    public Word(String word){
        this.word = new StringBuilder(word);
        wordID = idCounter++;
    }

    public Word(){
        this.word = new StringBuilder("");
        wordID = idCounter++;
    }

    public StringBuilder getWord() {
        return word;
    }

    public void setWord(String word) {
        int stringBuilderLength;

        stringBuilderLength = this.word.length();
        this.word.delete(0, stringBuilderLength - 1);
        this.word.append(word);
    }

    @Override
    public String toString(){
        return word.toString();
    }

    @Override
    public int hashCode(){
        return Objects.hash(word);
    }

    @Override
    public boolean equals(Object otherObject){
        Word other;

        // test to see if the objects are identical
        if(this == otherObject) {
            return true;
        }

        // if otherObject is null returns false
        if(otherObject == null) {
            return false;
        }

        // if the classes do not match, they cannot be equal and false is returned
        if(this.getClass() != otherObject.getClass()){
            return false;
        }

        other = (Word) otherObject;

        return Objects.equals(this.getWord(), other.getWord());
    }
}
