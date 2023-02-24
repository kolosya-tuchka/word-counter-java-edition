import com.kolosya.csv_files.CSVConfig;
import com.kolosya.csv_files.CSVConfigBuilder;
import com.kolosya.csv_files.CSVRow;
import com.kolosya.csv_files.CSVWriter;
import com.kolosya.word_counter.*;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        String inputFilename = args.length > 0 ? args[0] : "src/Main.java";
        String outputFilename = args.length > 1 ? args[1] : "out.csv";

        try {
            WordCounterStats statsCollector = new WordCounterStats();
            WordCounter wordCounter = new WordCounterBuilder()
                    .setFilepath(inputFilename)
                    .createWordCounter();

            for (var word : wordCounter) {
                statsCollector.collect(word);
            }

            CSVWriter csvWriter = new CSVWriter(outputFilename);
            CSVConfig csvConfig = new CSVConfigBuilder().
                    setColDelim(";").
                    setRowDelim("\n").
                    setEscaping("\"").
                    createCSVConfig();

            CSVRow header = new CSVRow(csvConfig, "Word", "Count", "Percentage");
            csvWriter.write(header);

            var stats = statsCollector.getStatistics();
            Integer wordsCount = statsCollector.getWordsCount();

            for (var entry : stats) {
                float percentage = entry.getCount().floatValue() / wordsCount.floatValue() * 100;
                CSVRow csvRow = new CSVRow(csvConfig);
                csvRow.append(entry.getWord());
                csvRow.append(entry.getCount().toString());
                csvRow.append(Float.toString(percentage).replace('.', ','));
                csvWriter.write(csvRow);
            }        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
