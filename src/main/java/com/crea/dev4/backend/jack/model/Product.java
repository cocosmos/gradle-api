package com.crea.dev4.backend.jack.model;

import lombok.Setter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@AllArgsConstructor
@Entity
public class Product {
    @Id
    private int id;
    private String name;
    private String category;
    private float price;
    private float bitcoin;

    public Product() {
        this(0, "", "", 0.0f, 0.0f);
    }

}
