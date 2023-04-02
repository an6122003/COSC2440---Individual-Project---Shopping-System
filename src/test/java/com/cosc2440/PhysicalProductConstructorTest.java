package com.cosc2440;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PhysicalProductConstructorTest {
    @Test
    public void physicalProductTestConstructor() throws Exception {
        // Test case where product name is unique
        String name = "PhysicalProduct";
        String description = "Description";
        int quantityAvailable = 10;
        double price = 1;
        double weight = 12.0;
        
        PhysicalProduct product = new PhysicalProduct(name, description, quantityAvailable, price, weight);
        
        // Check that the properties of the product are set correctly
        assertEquals(name, product.getName());
        assertEquals(description, product.getDescription());
        assertEquals(quantityAvailable, product.getQuantityAvailable());
        assertEquals(price, product.getPrice());
        assertEquals(weight, product.getWeight());
    }
}
