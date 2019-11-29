package com.technical.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DBUtils {
    private static final String DB_NAME = "records.db";

    private static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:src\\main\\resources\\" + DB_NAME;
            conn = DriverManager.getConnection(url);
        } catch (SQLException dbe) {
            System.out.println(dbe.getLocalizedMessage());
        }
        return conn;
    }

    static void insertAll(List<Record> recordsList) {

    }
}
