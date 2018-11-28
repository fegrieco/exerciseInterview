package com.lastminute.exercise.domain;

public class ExemptProduct implements Product {
    private String name;
    private boolean importProduct;
    private double priceWithOutTax;
    private double priceWithTax;
    private int importTaxRate;
    private int numberOfProduct;

    public ExemptProduct(String name, double priceWithOutTax, boolean importProduct,int importTaxRate, int numberOfProduct) {
        this.name = name;
        this.importProduct = importProduct;
        this.priceWithOutTax = priceWithOutTax;
        this.importTaxRate = importTaxRate;
        this.numberOfProduct = numberOfProduct;
    }


    @Override
    public double getProductPrice() {
        return this.priceWithOutTax;
    }

    @Override
    public int getProductTax() {
        return this.importProduct ? this.importTaxRate:0;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setFinalPrice(double price) {
        this.priceWithTax = price;
    }

    @Override
    public double getFinalPrice() {
        return this.priceWithTax;
    }

    public boolean isImportProduct() {
        return importProduct;
    }

    public int getImportTaxRate() {
        return importTaxRate;
    }

    public int getNumberOfProduct() {
        return numberOfProduct;
    }
}
