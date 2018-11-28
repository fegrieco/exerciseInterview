package com.lastminute.exercise.domain;

import com.lastminute.exercise.ports.Cashier;
import com.lastminute.exercise.util.NumericUtil;


import java.util.List;

public class ShoppingBasket {
    private String basketId;
     private List<Product> productsBought;
     private double total;
     private double salesTax;

    public ShoppingBasket(List<Product> productsBought,String basketId) {
        this.productsBought = productsBought;
        this.basketId=basketId;
    }

    public void checkOut(Cashier cashierService){
        productsBought.forEach(item ->{
            double tax = cashierService.getProductTax(item.getProductPrice(),item.getProductTax());
            double priceWithTax = cashierService.getTotalCount(item.getProductPrice(),tax);
            item.setFinalPrice(priceWithTax);
            this.total =this.total+(item.getNumberOfProduct()*priceWithTax);
            this.salesTax =this.salesTax + (item.getNumberOfProduct()*tax);
        });
    }

    public String getBasketId() {
        return this.basketId;
    }

    public List<Product> getProductsBought() {
        return this.productsBought;
    }

    public double getTotal() {
        return NumericUtil.round2Decimal(this.total);
    }

    public double getSalesTax() {
        return NumericUtil.round2Decimal(this.salesTax);
    }
}
