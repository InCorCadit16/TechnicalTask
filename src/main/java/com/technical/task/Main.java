package com.technical.task;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> writings = FileUtils.readData();

        LinkedList<Record> records = new LinkedList<>();
        LinkedList<Record> errors = new LinkedList<>();
        for (String row : writings) {
            Record record = DataParser.parse(row);
            if (record.hasWrongData()) {
                errors.add(record);
            } else {
                records.add(record);
            }
        }

        DBUtils.insertAll(records);
        FileUtils.submitErrorFile(errors);
        FileUtils.submitStatisticsFile(records.size(), errors.size());
    }
}
