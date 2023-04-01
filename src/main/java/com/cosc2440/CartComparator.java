package com.cosc2440;

import java.util.Comparator;

public class CartComparator implements Comparator<ShoppingCart>{

    @Override
    public int compare(ShoppingCart c1, ShoppingCart c2) {
        return Double.compare(c2.calculateWeight(), c1.calculateWeight());
    }
    
}
