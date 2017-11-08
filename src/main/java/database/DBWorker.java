package database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class DBWorker {
    private final String URL = "jdbc:mysql://188.166.161.108:3306/candidate";
    private final String USERNAME = "testcandidate";
    private final String PASSWORD = "Ej7mhonxAdHpNoNv";

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
