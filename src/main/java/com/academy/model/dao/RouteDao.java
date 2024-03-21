package com.academy.model.dao;

import com.academy.model.entity.Route;
import com.academy.model.entity.Ticket;
import com.academy.model.entity.User;

import java.util.List;

public interface RouteDao extends DefaultDao<Route, Integer> {
    List<Route> getAllWithCitesAndPlane();
}
