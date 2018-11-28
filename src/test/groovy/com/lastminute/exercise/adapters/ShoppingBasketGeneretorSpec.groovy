package com.lastminute.exercise.adapters

import com.lastminute.exercise.domain.ShoppingBasket
import com.lastminute.exercise.ports.ShoppingBasketGeneretor
import spock.lang.Specification

class ShoppingBasketGeneretorSpec extends Specification{

    def "Create Shopping Baskt"(){
        given:
        ShoppingBasketGeneretor generetor = new ShoppingBasketGeneretorImpl(new ProductGeneratorImpl())
        when:
        ShoppingBasket shBasket = generetor.createShoppingBasketFromFile("ShoppingBasket1.txt")
        then:
       shBasket.productsBought.size() == 3
    }
}
