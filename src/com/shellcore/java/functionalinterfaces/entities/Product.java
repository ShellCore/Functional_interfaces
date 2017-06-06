package com.shellcore.java.functionalinterfaces.entities;

import java.text.DecimalFormat;

/**
 * Created by Cesar. 06/06/2017.
 */
public class Product {

    private int id;
    private String name;
    private String category;
    private float price;

    public Product(int id, String name, String category, float price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.name + " " + (new DecimalFormat("$0.00").format(this.price));
    }
}
