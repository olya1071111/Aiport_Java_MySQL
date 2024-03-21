package com.academy.model.entity;

import lombok.Data;

import java.util.List;

@Data
public class Plane {
    private Integer id;
    private String number;
    List<Route> routes;
}
