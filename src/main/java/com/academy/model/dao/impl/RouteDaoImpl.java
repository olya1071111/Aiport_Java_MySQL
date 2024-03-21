package com.academy.model.dao.impl;

import com.academy.model.DataSource;
import com.academy.model.dao.RouteDao;
import com.academy.model.entity.*;
import com.academy.model.entity.Route;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RouteDaoImpl implements RouteDao {
    @Override
    public void save(Route route) {
        Connection connection = DataSource.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(" insert into airport.route (number, arrival_date, departure_date, arrival_city_id, departure_city_id, route_time, plane_id, stat, price) value  (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            statement.setInt(1, route.getNumber());

            Date date1 = route.getDeparture_date();
            statement.setDate(2, new java.sql.Date(date1.getTime()));
            Date date2 = route.getDeparture_date();
            statement.setDate(3, new java.sql.Date(date2.getTime()));
            statement.setInt(4, route.getArrival_city_id());
            statement.setInt(5, route.getDeparture_city_id());
            statement.setTime(6, route.getRoute_time());
            statement.setInt(7, route.getPlane_id());
            statement.setString(8, route.getStat());
            statement.setInt(9, route.getPrice());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        Connection connection = DataSource.getInstance().getConnection();

        try (PreparedStatement statement = connection.prepareStatement(" delete from airport.route where id = ?")) {
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Route> getAll() {

        Connection connection = DataSource.getInstance().getConnection();

        List<Route> routes = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement("select * from route")) {
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Route route = new Route();
                route.setId(result.getInt("id"));
                route.setNumber(result.getInt("number"));
                route.setArrival_date(result.getDate("arrival_date"));
                route.setDeparture_date(result.getDate("departure_date"));
                route.setArrival_city_id(result.getInt("arrival_city_id"));
                route.setDeparture_city_id(result.getInt("departure_city_id"));
                route.setRoute_time(result.getTime("route_time"));
                route.setPlane_id(result.getInt("plane_id"));
                route.setStat(result.getString("stat"));
                route.setPrice(result.getInt("price"));

                routes.add(route);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return routes;
    }

    @Override
    public Route getById(Integer id) {

        Connection connection = DataSource.getInstance().getConnection();

        Route route = new Route();

        try (PreparedStatement statement = connection.prepareStatement("select * from route where id=?")) {
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                route.setId(result.getInt("id"));
                route.setNumber(result.getInt("number"));
                route.setArrival_date(result.getDate("arrival_date"));
                route.setDeparture_date(result.getDate("departure_date"));
                route.setArrival_city_id(result.getInt("arrival_city_id"));
                route.setDeparture_city_id(result.getInt("departure_city_id"));
                route.setRoute_time(result.getTime("route_time"));
                route.setPlane_id(result.getInt("plane_id"));
                route.setStat(result.getString("stat"));
                route.setPrice(result.getInt("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return route;
    }

    @Override
    public List<Route> getAllWithCitesAndPlane() {

        Connection connection = DataSource.getInstance().getConnection();

        List<Route> routes = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement("SELECT plane.number as numberPlane, city.name as arrivalCity, city2.name as departureCity, route.id, route.number as numberRoute, arrival_date, departure_date, route_time, stat, price FROM airport.route join airport.city on arrival_city_id = city.id left join airport.city as city2 on departure_city_id = city2.id left join airport.plane on plane_id = plane.id")) {

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                List<Plane> planes = new ArrayList<>();
                if (result.getString("numberPlane") != null) {
                    Plane plane = new Plane();
                    plane.setNumber(result.getString("numberPlane"));
                    planes.add(plane);
                }

                List<City> arrivalCity = new ArrayList<>();
                if (result.getString("arrivalCity") != null) {
                    City city1 = new City();
                    city1.setName(result.getString("arrivalCity"));
                    arrivalCity.add(city1);
                }

                List<City> departureCity = new ArrayList<>();
                if (result.getString("departureCity") != null) {
                    City city2 = new City();
                    city2.setName(result.getString("departureCity"));
                    departureCity.add(city2);
                }

                Route route = new Route();
                route.setId(result.getInt("id"));
                route.setNumber(result.getInt("numberRoute"));
                route.setArrival_date(result.getDate("arrival_date"));
                route.setDeparture_date(result.getDate("departure_date"));
                route.setRoute_time(result.getTime("route_time"));
                route.setStat(result.getString("stat"));
                route.setPrice(result.getInt("price"));

                route.setPlanes(planes);
                route.setCities1(arrivalCity);
                route.setCities2(departureCity);
                routes.add(route);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return routes;
    }
}
