package com.cosc2440;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.util.ArrayList;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

/**
 * Unit test for simple App.
 */
public class DigitalProductConstructorTest 
{
    @Test
    public void digitalProductTestConstructor() throws Exception {
        // Test case where product name is unique
        String name = "DigitalProduct";
        String description = "Description";
        int quantityAvailable = 10;
        double price = 1;
        
        DigitalProduct product = new DigitalProduct(name, description, quantityAvailable, price);
        
        // Check that the properties of the product are set correctly
        assertEquals(name, product.getName());
        assertEquals(description, product.getDescription());
        assertEquals(quantityAvailable, product.getQuantityAvailable());
        assertEquals(price, product.getPrice());
    }
    

    // @Test
    // public void testDisplayProductList() {
    //     // Create some sample products
    //     Product.getProductList().add(new DigitalProduct("Ebook", "A digital book", 10, 9.99)); 
    //     Product.getProductList().add(new PhysicalProduct("T-shirt", "A cotton T-shirt", 20, 19.99, 0.2));

    //     // Verify the output
    //     String expectedOutput = "1. Type: Digital, Name: Ebook, Description: A digital book, Quantity: 10, Price: 9.9\n"
    //             + "2. Type: Physical, Name: T-shirt, Description: A cotton T-shirt, Quantity: 20, Price: 19.9, Weight: 0.2\n";
    //     assertEquals(expectedOutput, Product.displayProductList());
    // }

}
