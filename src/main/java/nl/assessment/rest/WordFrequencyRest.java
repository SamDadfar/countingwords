package nl.assessment.rest;

import nl.assessment.core.interfaces.WordFrequencyAnalyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordFrequencyRest {

    @Autowired
    private WordFrequencyAnalyzer wordFrequencyAnalyzer;

    @GetMapping("/getFrequency/{text}")
    public int getCalculateHighestFrequency(@PathVariable String text){
        return wordFrequencyAnalyzer.calculateHighestFrequency(text);
    }
}
