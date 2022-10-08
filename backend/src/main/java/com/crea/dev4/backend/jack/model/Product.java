package com.crea.dev4.backend.jack.model;

import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.crea.dev4.backend.jack.utils.GetPrice;

@AllArgsConstructor
@Entity
public class Product {
    @Id
    private int id;
    private String name;
    private String category;
    private float price;

    private float bitcoin;
    private float ethereum;

    public Product() {
        this(0, "", "", 0.0f, 0.0f, 0.0f);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBitcoin(float bitcoin) {
        this.bitcoin = bitcoin;
    }

    public void setEthereum(float ethereum) {
        this.ethereum = ethereum;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCategory() {
        return this.category;
    }

    public float getPrice() {
        return this.price;
    }

    /**
     * Get converted price in bitcoin
     * 
     * @return price in bitcoin
     */
    public float getBitcoin() {
        return this.price * GetPrice.getCoinRate("bitcoin", "usd");
    }

    /**
     * Get converted price in ethereum
     * 
     * @return price in ethereum
     */
    public float getEthereum() {
        return this.price * GetPrice.getCoinRate("ethereum", "usd");
    }

}
