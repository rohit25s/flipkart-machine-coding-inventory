package org.flipkart.model;

import lombok.Getter;

@Getter
public class Item {


    private String id;
    private String brand;
    private Category category;
    private double price;

    public Item(String id, String brand, Category category, double price){
        this.id = id;
        this.brand = brand;
        this.category = category;
        this.price = price;
    }


    public String getBrand() {
        return brand;
    }

    public Category getCategory(){
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
