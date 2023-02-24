package com.kolosya.csv_files;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter extends FileWriter {

    public CSVWriter(String fileName) throws IOException {
        super(fileName);
        if (!fileName.endsWith(".csv")) {
            throw new IOException("Expected .csv extension");
        }
    }

    public void write(CSVRow row) throws IOException {
        write(row.toString());
    }
}
