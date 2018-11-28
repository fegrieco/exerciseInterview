package com.lastminute.exercise.configuration;

import java.util.HashSet;
import java.util.Set;

public class Configuration {


    private static Set<String> exemptProduct = null;
    static	{
        exemptProduct = new HashSet<String>();
        exemptProduct.add("book");
        exemptProduct.add("headache pills");
        exemptProduct.add("packet of headache pills");
        exemptProduct.add("box of imported chocolates");
        exemptProduct.add("imported box of chocolates");
        exemptProduct.add("box of chocolates");
        exemptProduct.add("chocolate");
        exemptProduct.add("chocolate bar");
        exemptProduct.add("pills");
    }

    public static boolean isExemptProduct (String product){
        return exemptProduct.contains(product);
    }

}
