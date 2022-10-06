package com.crea.dev4.backend.jack.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crea.dev4.backend.jack.model.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer> {
    public List<Account> findAll();

    public Account findById(int id);
}
