package com.cosc2440;

/**
 * @author Nguyen Quoc An - s3938278
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SortCartByWeightTest {
    @Test
    public void testSortShoppingCartByWeightDescending() throws Exception {
        Product.getProductList().add(new PhysicalProduct("cool", "A cotton T-shirt", 20, 19.99, 0.2));
        Product.getProductList().add(new PhysicalProduct("very cool", "A vinyl record", 15, 14.99, 0.3));

        ShoppingCart shoppingCart1 = new ShoppingCart();
        ShoppingCart shoppingCart2 = new ShoppingCart();

        //Add item to cart
        shoppingCart1.addItem("cool");
        shoppingCart2.addItem("very cool"); //Heavier

        //Add heavier cart in order
        ShoppingCartList.getShoppingCartList().add(shoppingCart2);
        ShoppingCartList.getShoppingCartList().add(shoppingCart1);

        assertEquals(ShoppingCartList.sortShoppingCartByWeight(false), ShoppingCartList.getShoppingCartList());
        
    }

    @Test
    public void testSortShoppingCartByWeightAscending() throws Exception {
        Product.getProductList().add(new PhysicalProduct("cool", "A cotton T-shirt", 20, 19.99, 0.2));
        Product.getProductList().add(new PhysicalProduct("very cool", "A vinyl record", 15, 14.99, 0.3));

        ShoppingCart shoppingCart1 = new ShoppingCart();
        ShoppingCart shoppingCart2 = new ShoppingCart();

        //Add item to cart
        shoppingCart1.addItem("cool");
        shoppingCart2.addItem("very cool"); //Heavier

        //Add heavier cart in order
        ShoppingCartList.getShoppingCartList().add(shoppingCart1);
        ShoppingCartList.getShoppingCartList().add(shoppingCart2);

        assertEquals(ShoppingCartList.sortShoppingCartByWeight(true), ShoppingCartList.getShoppingCartList());
        
    }
}
