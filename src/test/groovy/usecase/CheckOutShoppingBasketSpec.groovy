package usecase

import com.lastminute.exercise.adapters.CashierImpl
import com.lastminute.exercise.adapters.ProductGeneratorImpl
import com.lastminute.exercise.adapters.ShoppingBasketGeneretorImpl
import com.lastminute.exercise.domain.ShoppingBasket
import com.lastminute.exercise.ports.Cashier
import com.lastminute.exercise.ports.ShoppingBasketGeneretor
import com.lastminute.exercise.util.PrinterUtil
import spock.lang.Specification

class CheckOutShoppingBasketSpec extends Specification {

    def "calculate total product in basket 1"(){
        given:"create Shop basket from file"
        ShoppingBasketGeneretor generetor = new ShoppingBasketGeneretorImpl(new ProductGeneratorImpl())
        ShoppingBasket shBasket = generetor.createShoppingBasketFromFile("ShoppingBasket1.txt")
        Cashier cashier = new CashierImpl()
        expect:"calcualte total"
        shBasket.checkOut(cashier)
        println(PrinterUtil.printInputPorductOfShoppingBasket(shBasket))
        println(PrinterUtil.printCheckOutOfShoppingBasket(shBasket))
        shBasket.getProductsBought().get(productIdx).finalPrice == priceWithTax
        shBasket.getTotal()== 29.83
        shBasket.getSalesTax() == 1.50
        where:
        productIdx | priceWithTax
        0          |   12.49
        1          |   16.49
        2          |   0.85
    }


    def "calculate total product in basket 2"(){
        given:"create Shop basket from file"
        ShoppingBasketGeneretor generetor = new ShoppingBasketGeneretorImpl(new ProductGeneratorImpl())
        ShoppingBasket shBasket = generetor.createShoppingBasketFromFile("ShoppingBasket2.txt")
        Cashier cashier = new CashierImpl()
        expect:"calcualte total"
        shBasket.checkOut(cashier)
        println(PrinterUtil.printInputPorductOfShoppingBasket(shBasket))
        println(PrinterUtil.printCheckOutOfShoppingBasket(shBasket))
        shBasket.getProductsBought().get(productIdx).finalPrice == priceWithTax
        shBasket.getTotal()== 65.15
        shBasket.getSalesTax() == 7.65
        where:
        productIdx | priceWithTax
        0          |   10.50
        1          |   54.65
    }

    def "calculate total product in basket 3"(){
        given:"create Shop basket from file"
        ShoppingBasketGeneretor generetor = new ShoppingBasketGeneretorImpl(new ProductGeneratorImpl())
        ShoppingBasket shBasket = generetor.createShoppingBasketFromFile("ShoppingBasket3.txt")
        Cashier cashier = new CashierImpl()
        expect:"calcualte total"
        shBasket.checkOut(cashier)
        println(PrinterUtil.printInputPorductOfShoppingBasket(shBasket))
        println(PrinterUtil.printCheckOutOfShoppingBasket(shBasket))
        shBasket.getProductsBought().get(productIdx).finalPrice == priceWithTax
        shBasket.getSalesTax() == 6.70
        shBasket.getTotal()== 74.68
        where:
        productIdx | priceWithTax
        0          |   32.19
        1          |   20.89
        2          |   9.75
        3          |   11.85
    }

    def "calculate total product in basket 4"(){
        given:"create Shop basket from file"
        ShoppingBasketGeneretor generetor = new ShoppingBasketGeneretorImpl(new ProductGeneratorImpl())
        ShoppingBasket shBasket = generetor.createShoppingBasketFromFile("ShoppingBasket4.txt")
        Cashier cashier = new CashierImpl()
        when:"calcualte total"
        shBasket.checkOut(cashier)
        println(PrinterUtil.printInputPorductOfShoppingBasket(shBasket))
        println(PrinterUtil.printCheckOutOfShoppingBasket(shBasket))
        then:
        shBasket.getTotal()== 30.68
        shBasket.getSalesTax() == 1.50
    }

    def "calculate total product in basket 5"(){
        given:"create Shop basket from file"
        ShoppingBasketGeneretor generetor = new ShoppingBasketGeneretorImpl(new ProductGeneratorImpl())
        ShoppingBasket shBasket = generetor.createShoppingBasketFromFile("ShoppingBasket5.txt")
        Cashier cashier = new CashierImpl()
        when:"calcualte total"
        shBasket.checkOut(cashier)
        println(PrinterUtil.printInputPorductOfShoppingBasket(shBasket))
        println(PrinterUtil.printCheckOutOfShoppingBasket(shBasket))
        then:
        shBasket.getTotal()== 46.32
        shBasket.getSalesTax() == 3

    }


}
