package com.academy;

import com.academy.model.DataSource;
import com.academy.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = DataSource.getInstance().getConnection();

        PreparedStatement statement = connection.prepareStatement("select * from user");

        ResultSet result = statement.executeQuery();

        List<User> users = new ArrayList<>();

        User user = null;
        while (result.next()) {
            user = new User();
            user.setId(result.getInt("id"));
            user.setName(result.getString("name"));
            user.setJob(result.getString("job"));

            users.add(user);
        }

        System.out.println("Hello world!");
    }
}
