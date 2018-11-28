package com.lastminute.exercise.domain;

public interface Product {

    double getProductPrice();

    int getProductTax ();

    String getName();

    void setFinalPrice(double price);

    double getFinalPrice();

    public int getNumberOfProduct();
}
