package com.academy.model.dao.impl;

import com.academy.model.DataSource;
import com.academy.model.dao.UserDao;
import com.academy.model.entity.Route;
import com.academy.model.entity.Ticket;
import com.academy.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public void save(User user) {
        Connection connection = DataSource.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(" insert into airport.user (name, job) value  (?, ?)")) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getJob());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        Connection connection = DataSource.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(" delete from airport.user where id = ?")) {
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {

        Connection connection = DataSource.getInstance().getConnection();

        List<User> users = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement("select * from user")) {
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                User user = new User();
                user.setId(result.getInt("id"));
                user.setName(result.getString("name"));
                user.setJob(result.getString("job"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User getById(Integer id) {
        Connection connection = DataSource.getInstance().getConnection();

        User user = new User();

        try (PreparedStatement statement = connection.prepareStatement("select * from user where id=?")) {
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                user.setId(result.getInt("id"));
                user.setName(result.getString("name"));
                user.setJob(result.getString("job"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAllWithTicket() {

        Connection connection = DataSource.getInstance().getConnection();

        List<User> users = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement("SELECT user.name, ticket.id as numberTicket, ticket.seat, ticket.stat, route.number as numberRoute,arrival_date, departure_date, price  FROM airport.ticket left join airport.user on user_id = user.id\n" +
                "left join airport.route on route_id = route.id;")) {

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                User user = new User();
                user.setName(result.getString("name"));

                List<Ticket> tickets = new ArrayList<>();
                if (result.getString("seat") != null) {
                    Ticket ticket = new Ticket();

                    ticket.setId(result.getInt("numberTicket"));
                    ticket.setSeat(result.getInt("seat"));
                    ticket.setStat(result.getString("stat"));

                    tickets.add(ticket);
                }

                List<Route> routes = new ArrayList<>();
                if (result.getDate("arrival_date") != null) {
                    Route route = new Route();
                    route.setNumber(result.getInt("numberRoute"));
                    route.setArrival_date(result.getDate("arrival_date"));
                    route.setDeparture_date(result.getDate("departure_date"));
                    route.setPrice(result.getInt("price"));

                    routes.add(route);
                }
                user.setTickets(tickets);
                user.setRoutes(routes);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;

    }

    @Override
    public List<User> getByName(String name) {
        return null;
    }
}
