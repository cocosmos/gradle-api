package com.crea.dev4.backend.jack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crea.dev4.backend.jack.dao.AccountDao;
import com.crea.dev4.backend.jack.model.Account;

@RestController
public class AccountController {
    @Autowired
    private AccountDao AccountDao;

    @GetMapping(value = "/account/{id}")
    public Account displayAccount(@PathVariable int id) {
        Account AccountFounded = AccountDao.findById(id);

        return AccountFounded;
    }

    @GetMapping(value = "/accounts")
    public List<Account> listAccounts() {
        return AccountDao.findAll();
    }

    @PostMapping(value = "/account/create")
    public Account createAccount(@RequestBody Account a) {
        AccountDao.save(a);
        return a;
    }

    @PostMapping(value = "/account/login")
    public boolean loginAccount(@RequestBody Account a) {
        boolean auth = false;
        Account AccountFinded = AccountDao.findByEmailLike(a.getEmail());
        if (AccountFinded != null) {
            if (AccountFinded.getPassword().equals(a.getPassword())) {
                auth = true;
            }
        }

        return auth;
    }

}
