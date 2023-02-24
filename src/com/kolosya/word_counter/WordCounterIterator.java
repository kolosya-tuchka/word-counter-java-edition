package com.kolosya.word_counter;

import java.util.Iterator;

public class WordCounterIterator implements Iterator<String> {

    private final WordCounter wordCounter;

    public WordCounterIterator(WordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    @Override
    public boolean hasNext() {
        return wordCounter.fileScanner.hasNext();
    }

    @Override
    public String next() {
        return wordCounter.fileScanner.next();
    }
}
