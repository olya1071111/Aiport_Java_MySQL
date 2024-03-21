package com.academy.model.entity;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Integer id;
    private String name;
    private String job;
    private List<Ticket> tickets;
    private List<Route> routes;
   }
