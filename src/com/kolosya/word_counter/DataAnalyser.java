package com.kolosya.word_counter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class DataAnalyser<DataType> implements Iterable<DataType>  {
    protected File inputFile;
    protected String filepath;
    protected Scanner fileScanner;

    public DataAnalyser(String filepath, Pattern delimPattern) throws IOException {
        this.filepath = filepath;
        inputFile = new File(this.filepath);
        fileScanner = new Scanner(inputFile.getAbsoluteFile());
        fileScanner.useDelimiter(delimPattern);
    }
}
