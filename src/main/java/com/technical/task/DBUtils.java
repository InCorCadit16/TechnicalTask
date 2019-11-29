package com.technical.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DBUtils {
    private static final int MAX_RECORDS_IN_QUERY = 900;
    private static final String DB_NAME = "records.db";
    private static final String TABLE_NAME = "RECORDS";

    private static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                                                        "A VARCHAR," + " B VARCHAR," +
                                                        "C VARCHAR," + " D VARCHAR," +
                                                        "E VARCHAR," + " F VARCHAR," +
                                                        "G VARCHAR," + " H VARCHAR," +
                                                        "I VARCHAR," + " J VARCHAR " +
                                                        ")";

    private static final String INSERT_RECORD_QUERY = "INSERT INTO " + TABLE_NAME + " VALUES(?,?,?,?,?,?,?,?,?,?)";

    private static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:" + FileUtils.WORK_DIR + DB_NAME;
            conn = DriverManager.getConnection(url);
        } catch (SQLException dbe) {
            System.out.println(dbe.getLocalizedMessage());
        }
        return conn;
    }

    static void insertAll(List<Record> recordsList) {
        try (Connection connection = connect()) {
            connection.setAutoCommit(false);
            connection.prepareStatement(CREATE_TABLE_QUERY).execute();

            try (PreparedStatement insertStatement = connection.prepareStatement(INSERT_RECORD_QUERY)) {

                int recordsCount = 0;
                for (Record record : recordsList) {
                    addRecordToBatch(record, insertStatement);

                    if (recordsCount == MAX_RECORDS_IN_QUERY) {
                        insertStatement.executeBatch();
                        connection.commit();
                        recordsCount = 0;
                    } else {
                        recordsCount++;
                    }
                }

                insertStatement.executeBatch();
                connection.commit();
            }
            System.out.println("Data inserted in records.db");
        } catch (SQLException se) {
            System.out.println(se.getLocalizedMessage());
        }
    }

    private static void addRecordToBatch(Record record, PreparedStatement insertStatement) throws SQLException {
        insertStatement.setString(1,record.getA());
        insertStatement.setString(2,record.getB());
        insertStatement.setString(3,record.getC());
        insertStatement.setString(4,record.getD());
        insertStatement.setString(5,record.getE());
        insertStatement.setString(6,record.getF());
        insertStatement.setString(7,record.getG());
        insertStatement.setString(8,record.getH());
        insertStatement.setString(9,record.getI());
        insertStatement.setString(10,record.getJ());
        insertStatement.addBatch();
    }
}
