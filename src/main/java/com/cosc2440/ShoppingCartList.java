package com.cosc2440;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ShoppingCartList {
    private static int cartCount = 0;
    private static ArrayList<ShoppingCart> shoppingCartList = new ArrayList();

    public static void createShoppingCart(){
        shoppingCartList.add(new ShoppingCart());
        cartCount++;
        System.out.println("Shopping Cart created successfully!");
    }

    public static void viewAllShoppingCart(){
        if (ShoppingCartList.getShoppingCartList().size()==0){
            System.out.println("There are no shopping cart yet.");
        }
        for (ShoppingCart s: ShoppingCartList.getShoppingCartList()){
            System.out.println(s.toString());
            System.out.println();
        }
    }

    public static void viewAllShoppingCartSortedByWeight(){
        Scanner scanner = new Scanner(System.in);
        boolean isAscending;
        String input;
        if (ShoppingCartList.getShoppingCartList().size()==0){
            System.out.println("There are no shopping cart yet.");
        }else{
            System.out.println("Do you want to sort in Ascending or Descending order: ");
            input = scanner.nextLine();
            if (input.equals("Ascending")){
                isAscending = true;
            }else if (input.equals("Descending")){
                isAscending = false;
            }else{
                isAscending = false;
            }
            System.out.println("Shopping cart sorted by weight ("+input+" order):\n");
            for (ShoppingCart s: ShoppingCartList.sortShoppingCartByWeight(isAscending)){
                System.out.println(s.toString());
                System.out.println();
            }
        }
    }

    public static ArrayList<ShoppingCart> sortShoppingCartByWeight(boolean isAscending){
        ArrayList<ShoppingCart> returnSet;
        returnSet = (ArrayList<ShoppingCart>) ShoppingCartList.getShoppingCartList().clone(); // Have to clone, otherwise it change the reference not the value
        Collections.sort(returnSet,new CartComparator(isAscending));
        return returnSet;
    }

    //Getters and Setters 
    public static int getCartCount(){
        return cartCount;
    }

    public static ArrayList<ShoppingCart> getShoppingCartList(){
        return shoppingCartList;
    }    

}
