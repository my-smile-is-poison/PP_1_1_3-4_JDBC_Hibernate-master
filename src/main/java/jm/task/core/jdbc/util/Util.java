package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private static final String NAME_USER = "root";
    private static final String PASSWORD = "Wthrjdm8412rfh.";
    private static final String URL = "jdbc:mysql://localhost:3306/data_base";



    public static String getURL() {
        return URL;
    }

    public static String getPassword() {
        return PASSWORD;
    }

    public static String getNameUser() {
        return NAME_USER;
    }

    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(getURL(), getNameUser(), getPassword());
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.out.println("Could not connect to the database");
            e.printStackTrace();
        }

        return connection;
    }
    }


