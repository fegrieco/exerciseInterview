package com.lastminute.exercise.ports;

import com.lastminute.exercise.exception.CalcualteTaxException;

public interface Cashier  {

     double  getTotalCount(double priceProduct,double priceProductWithTax) throws CalcualteTaxException;

    double  getProductTax(double priceProduct,int tax) throws CalcualteTaxException;
}
