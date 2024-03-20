package com.academy.model.entity;

import lombok.Data;

@Data
public class UserPlane {
    private Integer id;
    private Integer plane_id;
    private Integer user_id;
    private String job;
}
