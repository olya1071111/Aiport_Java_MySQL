package com.academy.model;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {

    private static DataSource instance = new DataSource();
    private ComboPooledDataSource comboPooledDataSource;

    public static DataSource getInstance() {
        return instance;
    }

    private DataSource() {
        Properties properties = new Properties();

        try (InputStream inputStream = new FileInputStream("src/main/resources/db.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        comboPooledDataSource = new ComboPooledDataSource();

        comboPooledDataSource.setJdbcUrl(properties.getProperty("db.url"));
        comboPooledDataSource.setUser(properties.getProperty("db.user"));
        comboPooledDataSource.setPassword(properties.getProperty("db.password"));

        comboPooledDataSource.setInitialPoolSize(10);
        comboPooledDataSource.setMinPoolSize(10);
        comboPooledDataSource.setMaxPoolSize(20);
        comboPooledDataSource.setMaxConnectionAge(1000 * 60 * 60);
    }

    public Connection getConnection() {
        Connection connection = null;

        try {
            connection = comboPooledDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
