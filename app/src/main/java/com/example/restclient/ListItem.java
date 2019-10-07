package com.example.restclient;

import android.support.v7.app.AppCompatActivity;

public class ListItem extends AppCompatActivity {

  private String BeerName;
  private String Factory;
  private double Price;

    public ListItem(String beerName, String factory, double price) {
        this.BeerName = beerName;
        this.Factory = factory;
        this.Price = price;
    }

    public String getBeerName() {
        return BeerName;
    }

    public String getFactory() {
        return Factory;
    }

    public int getPrice() {
        return (int) Price;
    }
}
