package com.kolosya.csv_files;

public class CSVConfigBuilder {
    private String colDelim = ";";
    private String rowDelim = "\n";
    private String escaping = "\"";

    public CSVConfigBuilder setColDelim(String colDelim) {
        this.colDelim = colDelim;
        return this;
    }

    public CSVConfigBuilder setRowDelim(String rowDelim) {
        this.rowDelim = rowDelim;
        return this;
    }

    public CSVConfigBuilder setEscaping(String escaping) {
        this.escaping = escaping;
        return this;
    }

    public CSVConfig createCSVConfig() {
        return new CSVConfig(colDelim, rowDelim, escaping);
    }
}