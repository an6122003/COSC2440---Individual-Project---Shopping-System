package com.cosc2440;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RemoveItemTest {
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
}
