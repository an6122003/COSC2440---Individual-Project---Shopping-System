package com.cosc2440;

/**
 * @author Nguyen Quoc An - s3938278
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculateWeightTest {
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
}
