package com.academy.model.entity;

import lombok.Data;

import java.util.List;

@Data
public class City {
    private Integer id;
    private String name;
    List<Route> routes;
}
