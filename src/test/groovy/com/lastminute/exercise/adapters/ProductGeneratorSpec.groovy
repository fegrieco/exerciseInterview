package com.lastminute.exercise.adapters

import com.lastminute.exercise.configuration.RateTax
import com.lastminute.exercise.domain.ExemptProduct
import com.lastminute.exercise.domain.Product
import com.lastminute.exercise.domain.TaxedProduct
import com.lastminute.exercise.exception.InvalidProductExecption
import com.lastminute.exercise.ports.ProductGenerator
import spock.lang.Specification

class ProductGeneratorSpec extends Specification {

    def "create Taxed Product"(){
        given:
        String lineInput = "1 music CD at 14.99"
        ProductGenerator generator = new ProductGeneratorImpl()
        when:
        Product product = generator.getProduct(lineInput)
        TaxedProduct taxedProduct = (TaxedProduct) product;
        then:
        !taxedProduct.importProduct
        taxedProduct.name.equals("music CD")
        taxedProduct.importTaxRate==RateTax.IMPORTED_TAX.tax
        taxedProduct.productPrice ==14.99
        taxedProduct.taxRate==RateTax.SALES_TAX.tax
    }

    def "create Taxed Product impored"(){
        given:
        String lineInput = "1 bottle of perfume at 18.99"
        ProductGenerator generator = new ProductGeneratorImpl()
        when:
        Product product = generator.getProduct(lineInput)
        TaxedProduct taxedProduct = (TaxedProduct) product;
        then:
        !taxedProduct.importProduct
        taxedProduct.name.equals("bottle of perfume")
        taxedProduct.importTaxRate==RateTax.IMPORTED_TAX.tax
        taxedProduct.productPrice ==18.99
        taxedProduct.taxRate==RateTax.SALES_TAX.tax
    }

    def "create Exempt Product imported"(){
        given:
        String lineInput = "1 imported box of chocolates at 10.00"
        ProductGenerator generator = new ProductGeneratorImpl()
        when:
        Product product = generator.getProduct(lineInput)
        ExemptProduct taxedProduct = (ExemptProduct) product;
        then:
        taxedProduct.importProduct
        taxedProduct.name.equals("imported box of chocolates")
        taxedProduct.importTaxRate==RateTax.IMPORTED_TAX.tax
        taxedProduct.productPrice ==10.00
    }

    def "create Exempt Product "(){
        given:
        String lineInput = "1 chocolate bar at 0.85"
        ProductGenerator generator = new ProductGeneratorImpl()
        when:
        Product product = generator.getProduct(lineInput)
        ExemptProduct taxedProduct = (ExemptProduct) product;
        then:
        !taxedProduct.importProduct
        taxedProduct.name.equals("chocolate bar")
        taxedProduct.importTaxRate==RateTax.IMPORTED_TAX.tax
        taxedProduct.productPrice ==0.85
    }


    def "Product not respect format policy "(){
        given:
        String lineInput = " chocolate bar  0.85"
        ProductGenerator generator = new ProductGeneratorImpl()
        when:
        generator.getProduct(lineInput)
        then:
        thrown(InvalidProductExecption)
    }
}
