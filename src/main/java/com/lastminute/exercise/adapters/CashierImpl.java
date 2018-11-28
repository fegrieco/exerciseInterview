package com.lastminute.exercise.adapters;

import com.lastminute.exercise.exception.CalcualteTaxException;
import com.lastminute.exercise.ports.Cashier;
import com.lastminute.exercise.util.NumericUtil;

public class CashierImpl implements Cashier {


    @Override
    public  double getTotalCount(double priceProduct, double priceProductWitTax) {
        validateInput(priceProduct, priceProductWitTax);
        return NumericUtil.round2Decimal(priceProduct + priceProductWitTax);
    }

    @Override
    public double getProductTax(double priceProduct, int tax) throws CalcualteTaxException {
        validateInput(priceProduct, tax);
        return NumericUtil.roundOff((priceProduct * tax) / 100);
    }

    private void validateInput(double priceProduct, double tax) {
        if (priceProduct < 0 || tax < 0){
            throw new CalcualteTaxException("Sales tax and product price must be positive");
        }
    }


}
