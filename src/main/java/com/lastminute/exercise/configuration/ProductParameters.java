package com.lastminute.exercise.configuration;

public enum ProductParameters {
    PRICE("price"),
    QUANTITY("quantityProduct"),
    NAME_PRODUCT("nameProduct");

    private String value;
    ProductParameters(String value){
        this.value = value;
    }

    public String getParameter(){
        return this.value;
    }
}
