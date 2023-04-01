package com.cosc2440;

import java.util.ArrayList;

public class ShoppingCartList {
    private static int cartCount = 0;
    private static ArrayList<ShoppingCart> shoppingCartList = new ArrayList();

    public static void createShoppingCart(){
        shoppingCartList.add(new ShoppingCart());
        cartCount++;
        System.out.println("Shopping Cart created successfully!");
    }

    //Getters and Setters 
    public static int getCartCount(){
        return cartCount;
    }

    public static ArrayList<ShoppingCart> getShoppingCartList(){
        return shoppingCartList;
    }    

}
