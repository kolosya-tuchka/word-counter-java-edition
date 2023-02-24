package com.kolosya.word_counter;

import java.util.Locale;

public class WordCounterItem {
    private final String word;
    private final Integer count;

    public WordCounterItem(String word) {
        this.word = word;
        this.count = 0;
    }

    public WordCounterItem(String word, Integer count) {
        this.word = word;
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }

    public static int compare(WordCounterItem first, WordCounterItem second) {
        if (first.count < second.count) {
            return -1;
        }
        else if (first.count > second.count) {
            return 1;
        }
        else {
            return -first.word.toLowerCase(Locale.ROOT).compareTo(second.word.toLowerCase(Locale.ROOT));
        }
    }
}