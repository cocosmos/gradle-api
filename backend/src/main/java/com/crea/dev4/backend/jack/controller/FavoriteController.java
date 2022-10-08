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

    @GetMapping(value = "/favorites/{idAccount}")
    public List<Favorite> listFavorite(@PathVariable int idAccount) {
        return favoriteDao.findByAccountid(idAccount);
    }

    @PostMapping(value = "/favorite/add")
    public Favorite addFavorite(@RequestBody Favorite f) {
        return favoriteDao.save(f);
    }

    @RequestMapping(value = "/favorite/delete", method = { RequestMethod.DELETE, RequestMethod.GET,
            RequestMethod.POST })
    public void removeFavorite(@RequestBody Favorite f) {

        favoriteDao.delete(f);
    }

}
