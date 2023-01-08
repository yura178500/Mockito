package com.example.mockitowor.Service.impl;

import com.example.mockitowor.Model.User;
import com.example.mockitowor.Service.UserService;

public class UserServiceImpl implements UserService {

    private final DaoImpl daoImpl;

    public UserServiceImpl(DaoImpl daoImpl) {
        this.daoImpl = daoImpl;
    }

    public boolean checkUserExist(User user) {
        if (user != null) {
            return daoImpl.getUserByName(user.getName()) != null;
        }
        return false;
    }
}