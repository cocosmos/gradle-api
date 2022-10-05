package com.crea.dev4.backend.jack.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crea.dev4.backend.jack.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
    public List<Product> findAll();

    public Product findById(int id);

    public List<Product> findByPriceGreaterThan(float price);

    public List<Product> findByCategoryLike(String category);

    public Product findByNameLike(String name);

    /*
     * @Query(value="", nativeQuery = true);
     * public Produ
     */

    /* public Product createProduct(Product p); */
}
