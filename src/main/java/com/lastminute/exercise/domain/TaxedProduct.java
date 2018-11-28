package com.lastminute.exercise.domain;


public class TaxedProduct  implements Product {

    private String name;
    private boolean importProduct;
    private double priceWithOutTax;
    private double priceWithTax;
    private int taxRate;
    private int importTaxRate;
    private int numberOfProduct;

    public TaxedProduct(String name, double priceWithOutTax, int taxRate,boolean importProduct,int importTaxRate, int numberOfProduct) {
        this.name = name;
        this.importProduct = importProduct;
        this.priceWithOutTax = priceWithOutTax;
        this.taxRate = taxRate;
        this.importTaxRate = importTaxRate;
        this.numberOfProduct = numberOfProduct;
    }

    @Override
    public int getProductTax() {
        return this.importProduct ? this.taxRate+this.importTaxRate:this.taxRate;
    }

    @Override
    public double getProductPrice() {
        return this.priceWithOutTax;
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

    @Override
    public int getNumberOfProduct() {
        return this.numberOfProduct;
    }

    public boolean isImportProduct() {
        return importProduct;
    }

    public int getTaxRate() {
        return taxRate;
    }

    public int getImportTaxRate() {
        return importTaxRate;
    }
}
