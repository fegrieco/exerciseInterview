package com.lastminute.exercise.adapters;

import com.lastminute.exercise.configuration.Configuration;
import com.lastminute.exercise.configuration.ProductParameters;
import com.lastminute.exercise.configuration.RateTax;
import com.lastminute.exercise.domain.ExemptProduct;
import com.lastminute.exercise.domain.Product;
import com.lastminute.exercise.domain.TaxedProduct;
import com.lastminute.exercise.exception.InvalidProductExecption;
import com.lastminute.exercise.ports.ProductGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class ProductGeneratorImpl implements ProductGenerator {

    private static final Logger logger = LoggerFactory.getLogger(ProductGeneratorImpl.class);

    private static final String PRODUCT_REGEX = "(\\d+)\\s((\\w+\\s)+)at\\s(\\d+.\\d+)";

    @Override
    public Product getProduct(String line) {
        if (!validateProductInput(line)){
            logger.error("Porduct don't match wtih porduct policy: "+line);
            throw new InvalidProductExecption("Porduct don't match wtih porduct policy: "+line);
        }
        logger.info("Extract configuration Porduct properties");
        Map productParameters = extractParameters(line);
        int quantityProduct = (int)productParameters.get(ProductParameters.QUANTITY.getParameter());
        double price = (double)productParameters.get(ProductParameters.PRICE.getParameter());
        String nameProduct = (String) productParameters.get(ProductParameters.NAME_PRODUCT.getParameter());
        boolean isImported = nameProduct.contains("imported");
        return Configuration.isExemptProduct(nameProduct) ?
                new ExemptProduct(nameProduct,price,isImported,RateTax.IMPORTED_TAX.getTax(),quantityProduct):
                new TaxedProduct(nameProduct,price,RateTax.SALES_TAX.getTax(),isImported,RateTax.IMPORTED_TAX.getTax(),quantityProduct);

    }

    private boolean validateProductInput (String line){
        return line.matches(PRODUCT_REGEX);
    }

    private Map extractParameters(String line){
        Map values = new HashMap();
        String [] splitInputParam = line.split(" ");
        values.put(ProductParameters.QUANTITY.getParameter(), Integer.valueOf(splitInputParam[0]));
        int i = 1;
        String temp = splitInputParam[i];
        StringBuilder nameProductBuilder = new StringBuilder();
        while (!temp.equalsIgnoreCase("at") && i<splitInputParam.length){
            nameProductBuilder.append(temp).append(" ");
            i++;
            temp=splitInputParam[i];
        }
        values.put(ProductParameters.PRICE.getParameter(),Double.valueOf(splitInputParam[i+1])) ;
        String nameProduct = nameProductBuilder.toString();
        nameProduct = nameProduct.substring(0,nameProduct.length()-1);
        values.put(ProductParameters.NAME_PRODUCT.getParameter(),nameProduct);
        return values;
    }
}
