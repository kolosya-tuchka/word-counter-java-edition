package com.kolosya.csv_files;

import java.util.ArrayList;

public class CSVRow {
    private ArrayList<String> row;
    private CSVConfig config;

    public CSVRow(CSVConfig config) {
        this.config = config;
        this.row = new ArrayList<>();
    }

    public CSVRow(CSVConfig config, ArrayList<String> row) {
        this.row = new ArrayList<>(row);
        this.config = config;
    }

    public CSVRow(CSVConfig config, String... row) {
        this.config = config;
        this.row = new ArrayList<>();
        for (var cell : row) {
            this.append(cell);
        }
    }

    public void append(String cell) {
        row.add(cell);
    }

    @Override
    public String toString() {
        String result = "";
        for (String str : row) {
            String temp = new String(str);
            if (str.contains(config.getColDelim()) || str.contains(config.getRowDelim()) || str.contains(config.getEscaping())) {
                temp = str.replaceAll(config.getEscaping(), config.getEscaping() + config.getEscaping());
                temp = config.getEscaping() + str + config.getEscaping();
            }
            result += temp + config.getColDelim();
        }
        return result.substring(0, result.length() - 1) + config.getRowDelim();
    }
}
