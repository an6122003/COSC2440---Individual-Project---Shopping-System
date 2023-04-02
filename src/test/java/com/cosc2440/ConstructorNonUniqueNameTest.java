package com.cosc2440;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.util.ArrayList;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

public class ConstructorNonUniqueNameTest {
    @Test 
    public void testConstructorNonUniqueName() throws Exception {
        // Test case where product name is not unique, must be final for the anonymous inner class to fetch
        final String name = "Name";
        final String description = "Description";
        final int quantityAvailable = 10;
        final double price = 1;
        
        //Expect to throw an exception due to name is not unique
        assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Product.getProductList().add(new GiftableDigitalProduct("Online Course", "A comprehensive course on web development", 100, 500, "Happy learning!"));  
                Product.getProductList().add(new GiftableDigitalProduct("Online Course", "A comprehensive course on web development", 100, 500, "Happy learning!"));  
            }
        });
    }
}
