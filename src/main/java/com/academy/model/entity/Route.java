package com.academy.model.entity;

import lombok.Data;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
public class Route {
    private Integer id;
    private Integer number;
    private Date arrival_date;
    private Date departure_date;
    private Integer arrival_city_id;
    private Integer departure_city_id;
    private Time route_time;
    private Integer plane_id;
    private String stat;
    private Integer price;
    private List<City> cities1;
    private List<City> cities2;
    private List<Plane> planes;
}
