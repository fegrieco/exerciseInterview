package com.lastminute.exercise;

import com.lastminute.exercise.adapters.CashierImpl;
import com.lastminute.exercise.adapters.ProductGeneratorImpl;
import com.lastminute.exercise.adapters.ShoppingBasketGeneretorImpl;
import com.lastminute.exercise.domain.ShoppingBasket;
import com.lastminute.exercise.ports.Cashier;
import com.lastminute.exercise.ports.ShoppingBasketGeneretor;
import com.lastminute.exercise.util.PrinterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SalesTaxTool {

    private static final Logger logger = LoggerFactory.getLogger(SalesTaxTool.class);

    public static void main(String[] args){
        logger.info("Staring application");
        ShoppingBasketGeneretor generetor = new ShoppingBasketGeneretorImpl(new ProductGeneratorImpl());
        List<ShoppingBasket> baskets = new ArrayList<>();
        logger.info("Load shopping basket 1");
        baskets.add(generetor.createShoppingBasketFromFile("ShoppingBasket1.txt"));
        logger.info("Load shopping basket 2");
        baskets.add(generetor.createShoppingBasketFromFile("ShoppingBasket2.txt"));
        logger.info("Load shopping basket 3");
        baskets.add(generetor.createShoppingBasketFromFile("ShoppingBasket3.txt"));


        Cashier cashier = new CashierImpl();
       baskets.forEach(item -> {
           logger.info("CHECKOUT for basket Id ");
           item.checkOut(cashier);
           System.out.println(PrinterUtil.printInputPorductOfShoppingBasket(item));
           System.out.println(PrinterUtil.printCheckOutOfShoppingBasket(item));
       });

       logger.info("Stopping Application");
    }
}
