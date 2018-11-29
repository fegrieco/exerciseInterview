package com.lastminute.exercise.adapters;

import com.lastminute.exercise.domain.Product;
import com.lastminute.exercise.domain.ShoppingBasket;
import com.lastminute.exercise.ports.ProductGenerator;
import com.lastminute.exercise.ports.ShoppingBasketGeneretor;
import com.lastminute.exercise.util.InputReaderDataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasketGeneretorImpl implements ShoppingBasketGeneretor {

    private ProductGenerator productGenerator;

    private static final Logger logger = LoggerFactory.getLogger(ProductGeneratorImpl.class);

    public ShoppingBasketGeneretorImpl(ProductGenerator productGenerator) {
        this.productGenerator = productGenerator;
    }

    @Override
    public ShoppingBasket createShoppingBasketFromFile(String fileName)  {
        logger.info("Create shopping basket from file: "+fileName);
        List<String> detilsShoppingBasket = InputReaderDataUtil.readFileLineByLine(fileName);
        String basketId = detilsShoppingBasket.get(0);
        detilsShoppingBasket.remove(0);
        List<Product> products = new ArrayList();
        detilsShoppingBasket.forEach(item ->{
            products.add(productGenerator.getProduct(item));
        });
        return new ShoppingBasket(products,basketId);
    }
}
