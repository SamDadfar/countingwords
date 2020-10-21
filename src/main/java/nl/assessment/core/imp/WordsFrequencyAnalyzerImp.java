package nl.assessment.core.imp;

import nl.assessment.core.interfaces.WordFrenquency;
import nl.assessment.core.interfaces.WordFrequencyAnalyzer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordsFrequencyAnalyzerImp implements WordFrequencyAnalyzer {

    private static final String WORD_REQ_EXP = "[a-zA-Z]";
    final private List<WordFrenquency> wordFrequencies = new ArrayList<>();

    private void mountWordFrequencies(final String text) {
        String[] words;
        if (!text.isBlank()) {
            words = text.split("[\\s_\\-.]");
            Stream<String> wordStream = Stream.of(words);
            wordStream.filter(w -> !w.isBlank() && w.matches(WORD_REQ_EXP + "+")).forEach(word -> {
                if (wordFrequencies.stream().noneMatch(str -> str.getWord().equalsIgnoreCase(word))) {
                    int count = 0;
                    for (String str : words) {
                        if (str.equalsIgnoreCase(word)) {
                            count++;
                        }
                    }
                    final WordFrenquency frequency = new WordFrequencyImp(word, count);
                    wordFrequencies.add(frequency);
                }
            });
            wordFrequencies.sort(Comparator.comparing(WordFrenquency::getFrequency).reversed());
        }

    }

    @Override
    public int calculateHighestFrequency(String text) {
        mountWordFrequencies(text);
        final WordFrenquency highest = wordFrequencies
                .stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Empty text"));
        return highest.getFrequency();
    }

    @Override
    public int calculateFrequencyForWord(String text, String word) {
        mountWordFrequencies(text);
        final WordFrenquency matched = wordFrequencies
                .stream()
                .filter(frequency -> frequency.getWord().equalsIgnoreCase(word))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("word Not match"));
        return matched.getFrequency();
    }

    @Override
    public List<WordFrenquency> calculateMostFrequentNWords(String text, int n) {
        mountWordFrequencies(text);
        return wordFrequencies
                .stream()
                .limit(n)
                .collect(Collectors.toList());
    }
}

