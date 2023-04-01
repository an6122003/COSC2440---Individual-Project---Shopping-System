package com.cosc2440;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class ShoppingCartTest {
    @Test
    public void testAddItem() throws Exception{
        Product product1 = new DigitalProduct("product1", "Description",10, 2);
        Product product2 = new DigitalProduct("product2", "Description",1, 2);
        Product.getProductList().add(product1);

        ShoppingCart shoppingCart= new ShoppingCart();
        
        // Add valid item to shopping cart
        assertTrue(shoppingCart.addItem(product1.getName()));
        // Check product exist the shopping cart
        assertTrue(shoppingCart.getShoppingCart().contains(product1.getName()));
        // Check the size of the shopping cart
        assertEquals(1, shoppingCart.getShoppingCart().size());
        // Check quantity of the product added to cart
        assertEquals(9, product1.getQuantityAvailable());

        // Add item not in product list
        assertFalse(shoppingCart.addItem("product3"));
        // Check the size of the shopping cart
        assertEquals(1, shoppingCart.getShoppingCart().size());

        // Add item already in shopping cart
        assertFalse(shoppingCart.addItem(product1.getName()));
        // Check the size of the shopping cart
        assertEquals(1, shoppingCart.getShoppingCart().size());
        // Check quantity of the product added to cart
        assertEquals(9, product1.getQuantityAvailable());
    }

    @Test
    public void testRemoveItem() throws Exception{
        Product product1 = new DigitalProduct("product3", "Description",10, 2);
        ShoppingCart shoppingCart = new ShoppingCart();
        Product.getProductList().add(product1);


        shoppingCart.addItem(product1.getName());

        // Size of cart before removal
        assertEquals(1, shoppingCart.getShoppingCart().size());
        // Remove an item existed in the shopping cart
        assertTrue(shoppingCart.removeItem(product1.getName()));
        // Size of cart after removal
        assertEquals(0, shoppingCart.getShoppingCart().size());
        // Check shopping cart for existence of product
        assertFalse(shoppingCart.getShoppingCart().contains(product1));
        // Check quantity of product removed
        assertEquals(10, product1.getQuantityAvailable());

        // Remove item not in cart 
        assertFalse(shoppingCart.removeItem("product2"));
        // Check size of cart
        assertEquals(0, shoppingCart.getShoppingCart().size());

    }


    @Test
    public void testCalculateWeight() throws Exception{
        PhysicalProduct physicalProduct1 = new PhysicalProduct("physicalProduct1","Description", 20, 200, 10);
        PhysicalProduct physicalProduct2 = new PhysicalProduct("physicalProduct2","Description", 20, 200, 10);
        GiftablePhysicalProduct giftablePhysicalProduct1 = new GiftablePhysicalProduct("giftablePhysicalProduct1","Description", 20, 200, 10,"GiftMessage");
        ShoppingCart shoppingCart = new ShoppingCart();

        Product.getProductList().add(physicalProduct1);
        Product.getProductList().add(physicalProduct2);
        Product.getProductList().add(giftablePhysicalProduct1);

        // Add 3 physical items
        shoppingCart.addItem(physicalProduct1.getName());
        shoppingCart.addItem(physicalProduct2.getName());
        shoppingCart.addItem(giftablePhysicalProduct1.getName());

        double expectedWeight = physicalProduct1.getWeight() + physicalProduct2.getWeight() + giftablePhysicalProduct1.getWeight();

        // Test the weight calculate method
        assertEquals(expectedWeight,shoppingCart.calculateWeight());

    }

    @Test
    public void testCreateShoppingCart() {
        //Create a shopping cart
        ShoppingCart.createShoppingCart();
        assertEquals(1, ShoppingCart.getShoppingCartList().size());
    }

    
}
