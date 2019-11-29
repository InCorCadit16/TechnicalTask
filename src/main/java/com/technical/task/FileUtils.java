package com.technical.task;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    static final String WORK_DIR = "src\\main\\resources\\";
    private static final int BUFFER_ALLOC = 8192;
    private static final String TIMESTAMP = "YYYY-mm-dd_hh-MM-ss";

    static LinkedList<String> readData() {
        LinkedList<String> writings = new LinkedList<>();
        Path path = Paths.get(WORK_DIR + "X.csv");
        try (Scanner scanner = new Scanner(path)) {
            // Miss first line with "A,B,C,D,E,F,G,H,I,J"
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                writings.add(scanner.nextLine());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return writings;
    }

    static void submitErrorFile(List<Record> errors) {
        String fileName = buildErrorFileName();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(WORK_DIR + fileName),BUFFER_ALLOC)) {
            for (Record badRecord : errors) {
                writer.write(badRecord.toString(),0,badRecord.toString().length());
                writer.newLine();
            }
            System.out.println("Error data inserted in error file");
        } catch (IOException ioe) {
            System.out.println(ioe.getLocalizedMessage());
        }
    }

    static void submitStatisticsFile(int goodRecords, int badRecords) {
        String fileName = "statistics.log";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(WORK_DIR + fileName),BUFFER_ALLOC)) {
            writer.write(goodRecords + badRecords + " of records received\n");
            writer.write(goodRecords + " of records successful\n");
            writer.write(badRecords + " of records failed");
            System.out.println("Log file filled up");
        } catch (IOException ioe) {
            System.out.println(ioe.getLocalizedMessage());
        }
    }

    private static String buildErrorFileName() {
        SimpleDateFormat format = new SimpleDateFormat(TIMESTAMP);
        return "bad-data-" + format.format(new Date()) + ".csv";
    }
}
