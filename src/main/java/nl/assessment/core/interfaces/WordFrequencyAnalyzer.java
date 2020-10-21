package nl.assessment.core.interfaces;

import java.util.List;

public interface WordFrequencyAnalyzer {
    int calculateHighestFrequency(String text);
    int calculateFrequencyForWord(String text, String word);
    List<WordFrenquency> calculateMostFrequentNWords(String text, int n);
}
