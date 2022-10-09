package com.crea.dev4.backend.jack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crea.dev4.backend.jack.dao.ProductDao;
import com.crea.dev4.backend.jack.dao.exception.ProductNotFoundException;
import com.crea.dev4.backend.jack.model.Product;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    /**
     * Display product
     * 
     * @param id of the product
     * @return the product
     */
    @GetMapping(value = "/product/{id}")
    public Product displayProduct(@PathVariable int id) {
        Product productFounded = productDao.findById(id);

        if (productFounded == null) {
            throw new ProductNotFoundException("Product not found with id" + id);
        }

        return productFounded;
    }

    /**
     * List of all products
     * 
     * @return all products
     */
    @GetMapping(value = "/products")
    public List<Product> listproducts() {
        return productDao.findAll();
    }

    /**
     * List products by price greater than the @param
     * 
     * @param price
     * @return list of products
     */
    @GetMapping(value = "/products-price/{price}")
    public List<Product> listProductsByPrice(@PathVariable float price) {
        return productDao.findByPriceGreaterThan(price);
    }

    /**
     * Find a product by name
     * 
     * @param name
     * @return the product
     */
    @GetMapping(value = "/product/name/{name}")
    public Product displayProductByName(@PathVariable String name) {
        return productDao.findByNameLike(name);
    }

    /**
     * list products by category
     * 
     * @param category
     * @return a list of product
     */
    @GetMapping(value = "/category/{category}")
    public List<Product> listProductsByCategory(@PathVariable String category) {
        return productDao.findByCategoryLike(category);
    }

    /**
     * Create a product
     * 
     * @param p product
     * @return product
     */
    @PostMapping(value = "/product/create")
    public Product createProduct(@RequestBody Product p) {
        productDao.save(p);
        return p;
    }

    /**
     * Delete a product
     * 
     * @param id
     */
    @RequestMapping(value = "/product/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET,
            RequestMethod.POST })
    public void deleteProduct(@PathVariable int id) {
        Product productFinded = productDao.findById(id);

        productDao.delete(productFinded);
    }

}
