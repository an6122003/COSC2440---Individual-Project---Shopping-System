package com.cosc2440;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.util.ArrayList;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

/**
 * Unit test for simple App.
 */
public class ProductTest 
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
    
    @Test 
    public void testConstructorNegativeQuantity() throws Exception {
        //Expect to throw an exception due to negative quantity
        assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Product product = new DigitalProduct("product","Description",-10,1);
            }
        });
    }

    @Test
    public void testToStringPhysicalProduct() throws Exception{
        PhysicalProduct product = new PhysicalProduct("product","Description",10,1,10);
        assertEquals("PHYSICAL - product", product.toString());
    }

    @Test
    public void testToStringDigitalProduct() throws Exception{
        DigitalProduct product = new DigitalProduct("digital product","Description",10,1);
        assertEquals("DIGITAL - digital product", product.toString());
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
