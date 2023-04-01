package com.cosc2440;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CreateShoppingCartTest {
    @Test
    public void testCreateShoppingCart() {
        //Create a shopping cart
        ShoppingCartList.createShoppingCart();
        assertEquals(1, ShoppingCartList.getShoppingCartList().size());
    }
}
