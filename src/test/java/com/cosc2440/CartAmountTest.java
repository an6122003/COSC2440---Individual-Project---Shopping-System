package com.cosc2440;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CartAmountTest {
    @Test
    public void testCartAmount() throws Exception{
        DigitalProduct digitalProduct1 = new DigitalProduct("digitalProduct1", "Description",10,100);
        PhysicalProduct physicalProduct1 = new PhysicalProduct("physicalProduct","Description", 20, 200, 10);
        GiftablePhysicalProduct giftablePhysicalProduct1 = new GiftablePhysicalProduct("giftablePhysicalProduct","Description", 20, 200, 10,"GiftMessage");
        GiftableDigitalProduct giftableDigitalProduct1 = new GiftableDigitalProduct("giftableDigitalProduct1", "Description",10,100,"Message");
        ShoppingCart shoppingCart = new ShoppingCart();

        Product.getProductList().add(physicalProduct1);
        Product.getProductList().add(digitalProduct1);
        Product.getProductList().add(giftablePhysicalProduct1);
        Product.getProductList().add(giftableDigitalProduct1);


        // Add 4 items
        shoppingCart.addItem(digitalProduct1.getName());
        shoppingCart.addItem(physicalProduct1.getName());
        shoppingCart.addItem(giftableDigitalProduct1.getName());
        shoppingCart.addItem(giftablePhysicalProduct1.getName());
        
        // Test the cart amount with one digital product and one physical product
        double expectedAmount = digitalProduct1.getPrice() + physicalProduct1.getPrice() + physicalProduct1.getWeight() * shoppingCart.getBASE_FEE() + giftableDigitalProduct1.getPrice() + giftablePhysicalProduct1.getPrice() + giftablePhysicalProduct1.getWeight() * shoppingCart.getBASE_FEE();
        assertEquals(expectedAmount, shoppingCart.cartAmount());

    }
}
