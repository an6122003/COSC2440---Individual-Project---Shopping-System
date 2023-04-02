package com.cosc2440;

import java.util.Comparator;

public class CartComparator implements Comparator<ShoppingCart>{
    private boolean isAscending;

    public CartComparator(boolean isAscending){
        this.isAscending = isAscending;
    }

    @Override
    public int compare(ShoppingCart c1, ShoppingCart c2) {
        if (isAscending){
            return Double.compare(c1.calculateWeight(), c2.calculateWeight());
        }else{
            return Double.compare(c2.calculateWeight(), c1.calculateWeight());
        }
    }
    
}
