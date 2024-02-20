package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private static final String NAME_USER = "root";
    private static final String PASSWORD = "Wthrjdm8412rfh.";
    private static final String URL = "jdbc:mysql://localhost:3306/data_base";

    private static Connection connection;




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


        try {
            connection = DriverManager.getConnection(getURL(), getNameUser(), getPassword());
            System.out.println("Соединение с базой данных установленно");
        } catch (SQLException e) {
            System.out.println("Случился анлак и вы не подключились");
            e.printStackTrace();
        }

        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Соединение с базой данных закрыто");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


