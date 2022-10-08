package com.crea.dev4.backend.jack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = "/product/{id}")
    public Product displayProduct(@PathVariable int id) {
        Product productFounded = productDao.findById(id);

        if (productFounded == null) {
            throw new ProductNotFoundException("Product not found with id" + id);
        }

        return productFounded;
    }

    @GetMapping(value = "/products")
    public List<Product> listproducts() {
        return productDao.findAll();
    }

    @GetMapping(value = "/products-price/{price}")
    public List<Product> listProductsByPrice(@PathVariable float price) {
        return productDao.findByPriceGreaterThan(price);
    }

    @GetMapping(value = "/name/{name}")
    public Product displayProductByName(@PathVariable String name) {
        return productDao.findByNameLike(name);
    }

    @GetMapping(value = "/category/{category}")
    public List<Product> listProductsByCategory(@PathVariable String category) {
        return productDao.findByCategoryLike(category);
    }

    @PostMapping(value = "/create")
    public Product createProduct(@RequestBody Product p) {
        productDao.save(p);
        return p;
    }

    @RequestMapping(value = "/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST })
    public void deleteProduct(@PathVariable int id) {
        Product productFinded = productDao.findById(id);

        productDao.delete(productFinded);
    }

}
