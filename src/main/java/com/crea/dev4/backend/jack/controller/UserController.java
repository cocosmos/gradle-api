package com.crea.dev4.backend.jack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.crea.dev4.backend.jack.dao.UserDao;
import com.crea.dev4.backend.jack.model.User;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping(value = "/user/{id}")
    public User displayUser(@PathVariable int id) {
        User userFounded = userDao.findById(id);

        return userFounded;
    }

    @GetMapping(value = "/users")
    public List<User> listUsers() {
        return userDao.findAll();
    }

}
