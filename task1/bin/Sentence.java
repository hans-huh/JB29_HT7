package by.ld.hw.ooptasks.task1.bin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sentence {

    private static int idCounter = 1;
    private List<Word> sentence;
    private int sentenceID;

    public Sentence(){
        sentence = new ArrayList<>();
        sentence.add(new Word(""));
    }

    public Sentence(Word... words){
        sentence = new ArrayList<>();
        sentenceID = idCounter++;
        for(int i = 0; i < words.length; i++){
            sentence.add(words[i]);
        }
    }

    public List<Word> getSentence(){
        return sentence;
    }


    @Override
    public String toString(){
        String output;
        int listLength;

        output = new String("");
        listLength = sentence.size();
        for(int i = 0; i < listLength; i++){
            if(i + 1 != listLength){
                output += sentence.get(i).toString() + " ";
            } else {
                output += sentence.get(i).toString();
            }
        }
        output += ". ";

        return output;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentence);
    }

    @Override
    public boolean equals(Object otherObject){
        Sentence other;
        boolean result;
        int length;

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

        other = (Sentence) otherObject;

        // if the two lists have different size, return false
        if(this.getSentence().size() != other.getSentence().size()){
            return false;
        }

        length = sentence.size();
        result = true;

        for(int i = 0; i < length; i++){
            if(!this.getSentence().get(i).equals(other.getSentence().get(i))){
                result = false;
            }
        }

        return result;
    }

}
