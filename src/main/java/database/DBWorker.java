package database;

import java.sql.*;

public class DBWorker {

    /**
     * Set data source details and credentials
     */
    private final String HOST = "188.166.161.108";
    private final String PORT = "3306";
    private final String DB = "candidate";
    private final String DRIVER = "mysql";
    private final String USERNAME = "testcandidate";
    private final String PASSWORD = "Ej7mhonxAdHpNoNv";

    private final String URL = "jdbc:" + DRIVER + "://" + HOST + ":" + PORT + "/" + DB;

    private Connection connection;

    /**
     * Establishing DB connection
     */
    public DBWorker() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return Connection connection
     */
    public Connection getConnection() {
        return connection;
    }
}
