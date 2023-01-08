package com.example.mockitowor.Service.impl;

import com.example.mockitowor.Model.User;
import com.example.mockitowor.Service.Dao;

import java.util.Arrays;
import java.util.List;

public class DaoImpl implements Dao<User> {

    private final List<User> users = Arrays.asList(
            new User("Tom", 33),
            new User("Anna", 22)
    );

    @Override
    public User getUserByName(String name) {
        for (User user: users) {
            if (user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return users.stream().toList();
    }
}