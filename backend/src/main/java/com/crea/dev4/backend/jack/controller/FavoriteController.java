package com.crea.dev4.backend.jack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crea.dev4.backend.jack.dao.FavoriteDao;
import com.crea.dev4.backend.jack.model.Favorite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class FavoriteController {
    @Autowired
    private FavoriteDao favoriteDao;

    /**
     * List all favorite product by accountId
     * 
     * @param AccountId
     * @return list of favorites
     */
    @GetMapping(value = "/favorites/{idAccount}")
    public List<Favorite> listFavorite(@PathVariable int AccountId) {
        return favoriteDao.findByAccountid(AccountId);
    }

    /**
     * Add a favorite product
     * 
     * @param f favorite
     * @return favorite
     */
    @PostMapping(value = "/favorite/add")
    public Favorite addFavorite(@RequestBody Favorite f) {
        return favoriteDao.save(f);
    }

    /**
     * Remove a favorite product
     * 
     * @param f favorite
     * @return void
     */
    @RequestMapping(value = "/favorite/remove", method = { RequestMethod.DELETE, RequestMethod.GET,
            RequestMethod.POST })
    public void removeFavorite(@RequestBody Favorite f) {

        favoriteDao.delete(f);
    }

}
