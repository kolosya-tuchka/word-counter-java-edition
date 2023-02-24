package com.kolosya.csv_files;

public class CSVConfig {
    private final String colDelim, rowDelim, escaping;

    protected CSVConfig(String colDelim, String rowDelim, String escaping) {
        this.colDelim = colDelim;
        this.rowDelim = rowDelim;
        this.escaping = escaping;
    }

    public String getColDelim() {
        return colDelim;
    }

    public String getRowDelim() {
        return  rowDelim;
    }

    public String getEscaping() {
        return escaping;
    }
}
