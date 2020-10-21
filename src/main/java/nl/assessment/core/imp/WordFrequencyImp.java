package nl.assessment.core.imp;

import nl.assessment.core.interfaces.WordFrenquency;

public class WordFrequencyImp implements WordFrenquency {

    private String word;
    private int frequency;

    public WordFrequencyImp(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    @Override
    public String getWord() {
        return word;
    }

    @Override
    public int getFrequency() {
        return frequency;
    }
}
