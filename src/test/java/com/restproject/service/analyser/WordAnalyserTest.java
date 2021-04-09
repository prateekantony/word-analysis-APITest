package com.restproject.service.analyser;

import com.restproject.service.model.URILink;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WordAnalyserTest
{
    URILink urlLink;
    URILink urlLinkDefault = new URILink("https://prateekantony.github.io/test-file-dump/files/sample1.txt");

    WordAnalyser input1 = new WordAnalyser("Hello World");
    WordAnalyser input2 = new WordAnalyser("5. words in this parameter.");
    WordAnalyser input3 = new WordAnalyser(urlLinkDefault.getDataFromURL());
    WordAnalyser input4 = new WordAnalyser("Hi Hello World");

    @Test
    void getDataFromURLTest()
    {
        urlLink = new URILink("https://prateekantony.github.io/test-file-dump/files/sample1.txt");
        String expected = "\tHello world & good morning. The date is 18/05/2016";
        assertEquals(expected, urlLink.getDataFromURL());

        urlLink = new URILink("https://prateekantony.github.io/test-file-dump/files/sample2.txt");
        String expected2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam fermentum risus quis ligula vehicula rutrum. Phasellus a lacus dolor. Nulla tristique ex diam, et vehicula urna pulvinar ac. Donec sit amet magna eget massa ullamcorper gravida ut a lorem. Donec feugiat scelerisque nulla, sed efficitur neque hendrerit sit amet. Vivamus ligula nisi, gravida vel commodo sit amet, imperdiet et lorem. Nullam cursus condimentum leo, a gravida justo faucibus at. Aenean sed sem vehicula, pulvinar sem sit amet, efficitur magna. Fusce nibh nunc, pellentesque non justo nec, pellentesque fermentum diam. Quisque tempor ante eu commodo pulvinar. Pellentesque rhoncus in ex pulvinar.";
        assertEquals(expected2, urlLink.getDataFromURL());

        urlLink = new URILink("https://prateekantony.github.io/test-file-dump/files/sample4.txt");
        String expected3 = ". , ! \" £ $ % ^ & * (";
        assertEquals(expected3, urlLink.getDataFromURL());
    }

    @Test
    void getWordCountTest()
    {
        input1.splitWordsToList();
        int expected = 2;
        assertEquals(expected, input1.getListOfWordLengths().size());

        input2.splitWordsToList();
        int expected2 = 5;
        assertEquals(expected2, input2.getListOfWordLengths().size());

        input3.splitWordsToList();
        int expected3 = 9;
        assertEquals(expected3, input3.getListOfWordLengths().size());

        input4.splitWordsToList();
        int expected4 = 3;
        assertEquals(expected4, input4.getListOfWordLengths().size());
    }

    @Test
    void getListOfWordLengthsTest()
    {
        input1.splitWordsToList();
        String response = "[5, 5]";
        assertEquals(input1.getListOfWordLengths().toString(), response);

        input2.splitWordsToList();
        String response2 = "[1, 2, 4, 5, 9]";
        assertEquals(input2.getListOfWordLengths().toString(), response2);
    }

    @Test
    void splitWordsToListTest()
    {
        input1.splitWordsToList();
        String response = "[5, 5]";
        assertEquals(response, input1.getListOfWordLengths().toString());

        input2.splitWordsToList();
        String response2 = "[1, 2, 4, 5, 9]";
        assertEquals(response2, input2.getListOfWordLengths().toString());

        input2.splitWordsToList();
        int response3 = 5;
        assertEquals(response3, input2.getListOfWordLengths().size());
    }

    @Test
    void getAverageWordLengthTest()
    {
        input1.splitWordsToList();
        double response = 5;
        assertEquals(response, input1.getAverageWordLength());

        input2.splitWordsToList();
        double response2 = 4.2;
        assertEquals(response2, input2.getAverageWordLength());
    }

    @Test
    void wordLengthCountTest()
    {
        input3.splitWordsToList();
        String expected = "Number of words of length 1 is 1\n" +
                "Number of words of length 2 is 1\n" +
                "Number of words of length 3 is 1\n" +
                "Number of words of length 4 is 2\n" +
                "Number of words of length 5 is 2\n" +
                "Number of words of length 7 is 1\n" +
                "Number of words of length 10 is 1\n";
        assertEquals(expected, input3.wordLengthCount(input3.getListOfWordLengths()));
    }

    @Test
    void mostFrequentlyOccurringTest()
    {
        input3.splitWordsToList();
        input3.wordLengthCount(input3.getListOfWordLengths());
        String expected = "The most frequently occurring word length is 2, for word lengths of 4 & 5";
        assertEquals(expected, input3.mostFrequentlyOccurring());

        input4.splitWordsToList();
        input4.wordLengthCount(input4.getListOfWordLengths());
        String expected2 = "The most frequently occurring word length is 2, for word lengths of 5";
        assertEquals(expected2, input4.mostFrequentlyOccurring());
    }

    @Test
    void finalResultGeneratorTest()
    {
        String expected = "Word count = 9\n" +
                "Average word length = 4.556\n" +
                "Number of words of length 1 is 1\n" +
                "Number of words of length 2 is 1\n" +
                "Number of words of length 3 is 1\n" +
                "Number of words of length 4 is 2\n" +
                "Number of words of length 5 is 2\n" +
                "Number of words of length 7 is 1\n" +
                "Number of words of length 10 is 1\n" +
                "The most frequently occurring word length is 2, for word lengths of 4 & 5";
        assertEquals(expected, input3.FinalResultGenerator());
    }
}