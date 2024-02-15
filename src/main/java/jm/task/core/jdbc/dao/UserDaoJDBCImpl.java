package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try(Connection connection = Util.getConnection();
            PreparedStatement statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS `data_base`.`new_table` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NULL,\n" +
                    "  `lastName` VARCHAR(45) NULL,\n" +
                    "  `age` INT NULL,\n" +
                    "  PRIMARY KEY (`id`));")) {
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void dropUsersTable() {
        try(Connection connection = Util.getConnection();
            PreparedStatement statement = connection.prepareStatement("DROP TABLE IF EXISTS new_table")) {
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        String query = "INSERT INTO new_table (name, lastName, age) VALUES (?, ?, ?)";
        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            System.out.println("An error occurred while saving user");
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try(Connection connection = Util.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM new_table WHERE id = ?")) {
            statement.setLong(1, id);
            statement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try(Connection connection = Util.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM new_table");
            ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                list.add(user);

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } return list;
    }

    public void cleanUsersTable() {
        try(Connection connection = Util.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM new_table")) {
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
