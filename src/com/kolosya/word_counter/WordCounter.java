package com.kolosya.word_counter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Pattern;

public class WordCounter extends DataAnalyser<String> {

    protected WordCounter(String filepath, Pattern delimPattern) throws IOException {
        super(filepath, delimPattern);
    }

    @Override
    public Iterator<String> iterator() {
        return new WordCounterIterator(this);
    }
}
