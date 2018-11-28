package com.lastminute.exercise.configuration;

public enum RateTax {
    SALES_TAX(10),
    IMPORTED_TAX(5);

    private int value;
     RateTax(int value){
        this.value = value;
    }

    public int getTax(){
         return this.value;
    }
}
