package com.restproject.service.analyser;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class WordAnalyser
{
    private int total;
    private long maxValue;
    private List<Integer> mostOccurring;
    private List<Integer> listOfWordLengths;
    private String inputText;

    public WordAnalyser() { }

    public WordAnalyser(String inputText) {
        this.inputText = inputText;
    }

    public String getInputText() {
        return this.inputText;
    }

    public List<Integer> getListOfWordLengths() {
        return this.listOfWordLengths;
    }

    /**
     * Format the content to:
     * --- Remove following punctuation [ . , ? : ; " ' ! ( ) ]
     * --- Removes extra white-spaces
     * --- Split words by single spaces
     */
    public void splitWordsToList()
    {
        listOfWordLengths = new ArrayList<>();
        String[] wordSplit = getInputText().replaceAll("[\\t\\n\\r]+"," ").replaceAll("[.,?;:'^!(){}]"," ").trim().replaceAll(" +", " ").split(" ");
        Arrays.stream(wordSplit).forEach(s -> {
            getListOfWordLengths().add(s.length());
            total += s.length();
        });
        Collections.sort(getListOfWordLengths());
    }

    public double getAverageWordLength()
    {
        double average = (double)total / (double)getListOfWordLengths().size();
        DecimalFormat threeDecimalPlaces = new DecimalFormat("#.###");
        return Double.valueOf(threeDecimalPlaces.format(average));
    }

    public String wordLengthCount(List<Integer> lengths)
    {
        mostOccurring = new ArrayList<>();
        StringBuilder mostOccurringLines = new StringBuilder();
        Map<Integer, Long> keyCounter = lengths.stream()
                .collect(Collectors.groupingBy(D -> D , Collectors.counting()));

        keyCounter.forEach((key, value) -> {
            mostOccurringLines.append("Number of words of length ")
                                .append(key)
                                .append(" is ")
                                .append(value)
                                .append("\n");
            maxValue = maxValue < value ? value : maxValue;
        });

        keyCounter.forEach((key, value) -> {
            if (value == maxValue) {
                mostOccurring.add(key);
            }
        });

        return mostOccurringLines.toString();
    }

    public String mostFrequentlyOccurring()
    {
        StringBuilder frequentlyOccurringWord = new StringBuilder();
        for(Integer i : mostOccurring) {
            frequentlyOccurringWord.append(i).append("  ");
        }
        String frequentWord = frequentlyOccurringWord.toString().trim().replaceAll(" +", " & ");

        return "The most frequently occurring word length is "
                + maxValue
                + ", for word lengths of "
                + frequentWord;
    }

    public String FinalResultGenerator()
    {
        StringBuilder result = new StringBuilder();
        splitWordsToList();

        result.append("Word count = ").append(getListOfWordLengths().size()).append("\n")
                .append("Average word length = ").append(getAverageWordLength()).append("\n")
                .append(wordLengthCount(getListOfWordLengths()))
                .append(mostFrequentlyOccurring());

        return result.toString();
    }
}