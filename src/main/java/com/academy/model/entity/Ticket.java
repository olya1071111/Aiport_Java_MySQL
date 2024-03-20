package com.academy.model.entity;

import lombok.Data;

@Data
public class Ticket {
    private Integer id;
    private Integer user_id;
    private Integer route_id;
    private String stat;
    private Integer seat;
}
