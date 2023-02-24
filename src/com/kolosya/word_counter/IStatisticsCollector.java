package com.kolosya.word_counter;

public interface IStatisticsCollector<DataType, StatsType> {
    public void collect(DataType data);
    public StatsType getStatistics();
}
