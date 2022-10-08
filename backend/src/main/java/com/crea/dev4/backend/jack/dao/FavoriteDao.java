package com.crea.dev4.backend.jack.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.crea.dev4.backend.jack.model.Favorite;
import java.util.List;

@Repository
public interface FavoriteDao extends JpaRepository<Favorite, Integer> {
    public List<Favorite> findByAccountid(int accountid);

}
