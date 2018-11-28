package com.lastminute.exercise.ports;

import com.lastminute.exercise.domain.Product;

public interface ProductGenerator {
     Product getProduct(String line);
}
