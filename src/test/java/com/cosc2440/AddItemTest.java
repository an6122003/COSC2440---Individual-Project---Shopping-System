package com.cosc2440;

/**
 * @author Nguyen Quoc An - s3938278
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class AddItemTest {
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
    
}
