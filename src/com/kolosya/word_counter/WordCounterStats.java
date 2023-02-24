package com.kolosya.word_counter;

import java.util.*;

public class WordCounterStats implements IStatisticsCollector<String, ArrayList<WordCounterItem>> {

    private final TreeMap<String, Integer> wordsStats;
    private int wordsCount;

    public WordCounterStats() {
        wordsStats = new TreeMap<>();
        wordsCount = 0;
    }

    @Override
    public void collect(String data) {
        wordsStats.merge(data, 1, Integer::sum);
        ++wordsCount;
    }

    @Override
    public ArrayList<WordCounterItem> getStatistics() {
        ArrayList<WordCounterItem> result = new ArrayList<>();
        for (var entry : wordsStats.entrySet()) {
            result.add(new WordCounterItem(entry.getKey(), entry.getValue()));
        }
        result.sort(Collections.reverseOrder(WordCounterItem::compare));
        return result;
    }

    public Integer getWordsCount() {
        return wordsCount;
    }
}
