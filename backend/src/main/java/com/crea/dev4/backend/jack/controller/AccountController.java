package com.crea.dev4.backend.jack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crea.dev4.backend.jack.dao.AccountDao;
import com.crea.dev4.backend.jack.dao.FavoriteDao;
import com.crea.dev4.backend.jack.dao.ProductDao;
import com.crea.dev4.backend.jack.model.Account;
import com.crea.dev4.backend.jack.model.Favorite;
import com.crea.dev4.backend.jack.model.Product;

@RestController
public class AccountController {
    @Autowired
    private AccountDao AccountDao;
    @Autowired
    private FavoriteDao favoriteDao;
    @Autowired
    private ProductDao productDao;

    /**
     * Display an user account
     * 
     * @param id of the user
     * @return the account
     */
    @GetMapping(value = "/account/{id}")
    public Account displayAccount(@PathVariable int id) {
        Account AccountFounded = AccountDao.findById(id);

        return AccountFounded;
    }

    /**
     * List of favorite products for a accountId
     * 
     * @param id of the account
     * @return list of favorite products
     */
    @GetMapping(value = "/account/{id}/favorite")
    public List<Product> displayProduct(@PathVariable int id) {

        List<Favorite> FavoritesFounded = favoriteDao.findByAccountid(id);
        List FavoriteProducts = new ArrayList<Product>();

        for (Favorite favorite : FavoritesFounded) {
            Product productFinded = productDao.findById(favorite.getProductid());
            FavoriteProducts.add(productFinded);
        }

        return FavoriteProducts;
    }

    /**
     * All accounts
     * 
     * @return all accounts
     */
    @GetMapping(value = "/accounts")
    public List<Account> listAccounts() {
        return AccountDao.findAll();
    }

    /**
     * 
     * @param a : Account to create
     * @return created account
     */
    @PostMapping(value = "/account/create")
    public Account createAccount(@RequestBody Account a) {
        AccountDao.save(a);
        return a;
    }

    /**
     * 
     * @param a : Account to login
     * @return authorized login or not
     */
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
