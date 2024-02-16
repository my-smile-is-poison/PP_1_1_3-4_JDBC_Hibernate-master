package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;

import static jm.task.core.jdbc.util.Util.closeConnection;


public class Main {
    private final static UserServiceImpl user = new UserServiceImpl();

    public static void main(String[] args) {


        user.createUsersTable();
        user.saveUser("Ivanov","Ivan",(byte) 19);
        user.saveUser("Petrov","Ivan",(byte) 25);
        user.saveUser("Sidorov","Ivan",(byte) 24);
        user.saveUser("Jabin","Ivan",(byte) 21);
        user.getAllUsers();
        user.cleanUsersTable();
        user.dropUsersTable();
        closeConnection();






    }
}
