package nl.assessment.core.imp;

import nl.assessment.core.interfaces.WordFrequencyAnalyzer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class WordsFrequencyAnalyzerImpTest {

    private WordFrequencyAnalyzer analyzer = new WordsFrequencyAnalyzerImp();

    private String text = "SOME Text consist of . Some letters that _ come frequently AS a string of leTTers in some lines";

    @Test
    void calculateHighestFrequency() {
        assertEquals(3, analyzer.calculateHighestFrequency(text));
    }

    @Test
    void calculateFrequencyForWord() {
        assertEquals(1, analyzer.calculateFrequencyForWord(text, "come"));
    }

    @Test
    void calculateMostFrequentNWords() {
        assertEquals(3, analyzer.calculateMostFrequentNWords(text, 3).size());
    }

}