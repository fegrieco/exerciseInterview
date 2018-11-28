package com.lastminute.exercise.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumericUtil {

    public static double roundOff (double totalCount){
        /*double temp  = totalCount*20.0;
        BigDecimal value = new BigDecimal(temp);
        int totalCountInt = value.setScale(0, RoundingMode.HALF_UP).intValue();*/
       int totalCountInt = (int) Math.ceil(totalCount * 20.0);
        return (double) totalCountInt/20 ;
    }

    public static double round2Decimal (double totalCount){
       BigDecimal value = new BigDecimal(totalCount);
       // return Math.round(totalCount * 100.0) /100.0 ;
        return  value.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

}
