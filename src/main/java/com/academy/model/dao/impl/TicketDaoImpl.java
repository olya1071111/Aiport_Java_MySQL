package com.academy.model.dao.impl;

import com.academy.model.DataSource;
import com.academy.model.dao.TicketDao;
import com.academy.model.entity.Ticket;
import com.academy.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDaoImpl implements TicketDao {
    @Override
    public void save(Ticket ticket) {
        Connection connection = DataSource.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(" insert into airport.ticket (user_id, route_id,stat,seat) value  (?, ?, ?, ?)")) {
            statement.setInt(1, ticket.getUser_id());
            statement.setInt(2, ticket.getRoute_id());
            statement.setString(3, ticket.getStat());
            statement.setInt(4, ticket.getSeat());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteById(Integer id) {
        Connection connection = DataSource.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(" delete from airport.ticket where id = ?")) {
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Ticket> getAll() {
        Connection connection = DataSource.getInstance().getConnection();

        List<Ticket> tickets = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement("select * from ticket")) {
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(result.getInt("id"));
                ticket.setUser_id(result.getInt("user_id"));
                ticket.setRoute_id(result.getInt("route_id"));
                ticket.setStat(result.getString("stat"));
                ticket.setSeat(result.getInt("seat"));

                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tickets;
    }


    @Override
    public Ticket getById(Integer id) {
        Connection connection = DataSource.getInstance().getConnection();

        Ticket ticket = new Ticket();

        try (PreparedStatement statement = connection.prepareStatement("select * from ticket where id=?")) {
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                ticket.setId(result.getInt("id"));
                ticket.setUser_id(result.getInt("user_id"));
                ticket.setRoute_id(result.getInt("route_id"));
                ticket.setStat(result.getString("stat"));
                ticket.setSeat(result.getInt("seat"));

                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticket;
    }

}
