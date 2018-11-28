package com.lastminute.exercise.ports;

import com.lastminute.exercise.domain.ShoppingBasket;

import java.io.IOException;

public interface ShoppingBasketGeneretor {

    ShoppingBasket createShoppingBasketFromFile (String fileName) ;
}
