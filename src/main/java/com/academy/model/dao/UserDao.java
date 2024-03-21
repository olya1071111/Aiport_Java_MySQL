package com.academy.model.dao;

import com.academy.model.entity.User;

import java.util.List;

public interface UserDao extends DefaultDao<User, Integer> {

    List<User> getAllWithTicket();

    List<User> getByName(String name);

}
