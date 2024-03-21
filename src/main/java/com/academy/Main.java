package com.academy;

import com.academy.model.dao.RouteDao;
import com.academy.model.dao.UserDao;
import com.academy.model.dao.impl.RouteDaoImpl;
import com.academy.model.dao.impl.UserDaoImpl;
import com.academy.model.entity.Route;
import com.academy.model.entity.User;

import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ParseException {

        RouteDao routeDao = new RouteDaoImpl();

        // get all routes
        List<Route> routes1 = routeDao.getAll();

        // get by Id routes
        Route route = routeDao.getById(2);

        // all routes width cites and plane
        List<Route> routes = routeDao.getAllWithCitesAndPlane();

        for (Route entity : routes) {
            System.out.println(entity);
        }

        // save Route
        /*Route route = new Route();
        route.setNumber(546);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        route.setArrival_date(dateFormat.parse("2024-03-24 17:00:00"));
        route.setDeparture_date(dateFormat.parse("2024-03-24 20:00:00"));
        route.setArrival_city_id(3);
        route.setDeparture_city_id(4);
        route.setRoute_time(Time.valueOf(LocalTime.of(3, 00)));
        route.setPlane_id(2);
        route.setStat("planned");
        route.setPrice(587);

        routeDao.save(route);*/

        //delete by Id
        routeDao.deleteById(10);

        //UserDao userDao = new UserDaoImpl();

        //  List<User> user = userDao.getAll();

        // User user = userDao.getById(2);

        //List<User> user = userDao.getAllWithTicket();

       /* User user = new User();
        user.setName("Vladimir");
        user.setJob("Customer");
        userDao.save(user);*/

        // userDao.deleteById(9);

        System.out.println("Hello world!");
    }
}
