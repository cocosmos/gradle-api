package com.crea.dev4.backend.jack.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crea.dev4.backend.jack.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    public List<User> findAll();

    public User findById(int id);
}
