package com.lastminute.exercise.adapters

import com.lastminute.exercise.exception.CalcualteTaxException
import com.lastminute.exercise.ports.Cashier
import spock.lang.Specification

class CashierSpec extends Specification {

    def "calcualte product price with tax"(){
        given:
        Cashier cashier = new CashierImpl()
        when:
        def priceWithTax = cashier.getProductTax(14.99,10)
        def totalPrice = cashier.getTotalCount(14.99,priceWithTax)
        then:
        totalPrice == 16.49
        priceWithTax == 1.50
    }

    def "calcualte Exempt product price with tax"(){
        given:
        Cashier cashier = new CashierImpl()
        when:
        def priceWithTax = cashier.getProductTax(0.85,0);
        def totalPrice = cashier.getTotalCount(0.85,priceWithTax)
        then:
        totalPrice == 0.85
        priceWithTax == 0
    }

    def "calcualte  product price with negative tax value"(){
        given:
        Cashier cashier = new CashierImpl()
        when:
        def priceWithTax = cashier.getTotalCount(0.85,-1)
        then:
        thrown(CalcualteTaxException)
    }


    def "calcualte  with negative product price value"(){
        given:
        Cashier cashier = new CashierImpl()
        when:
        def priceWithTax = cashier.getTotalCount(-2.3,10)
        then:
        thrown(CalcualteTaxException)
    }


}
