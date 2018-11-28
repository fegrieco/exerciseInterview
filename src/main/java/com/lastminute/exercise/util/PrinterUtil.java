package com.lastminute.exercise.util;

import com.lastminute.exercise.domain.ShoppingBasket;

public class PrinterUtil {

    public static String printCheckOutOfShoppingBasket(ShoppingBasket shoppingBasket){
        String basketIdNew = "Output "+shoppingBasket.getBasketId().trim().substring(shoppingBasket.getBasketId().length()-2,shoppingBasket.getBasketId().length()-1);
        StringBuilder builder =new StringBuilder();
        builder.append(basketIdNew).append(":").append("\n");
        shoppingBasket.getProductsBought().forEach(item ->{
            builder.append(item.getNumberOfProduct()).append(" ").append(item.getName()).append(": ").append(item.getFinalPrice()).append("\n");
        });
        builder.append("Sales Taxes: ").append(shoppingBasket.getSalesTax()).append("\n");
        builder.append("Total: ").append(shoppingBasket.getTotal()).append("\n");
        return builder.toString();
    }
    public static String printInputPorductOfShoppingBasket(ShoppingBasket shoppingBasket){
        StringBuilder builder =new StringBuilder();
        builder.append(shoppingBasket.getBasketId()).append("\n");
        shoppingBasket.getProductsBought().forEach(item ->{
            builder.append(item.getNumberOfProduct()).append(" ").append(item.getName()).append(" at ").append(item.getProductPrice()).append("\n");
        });
        return builder.toString();
    }

}
