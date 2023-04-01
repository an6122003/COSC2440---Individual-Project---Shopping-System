package com.cosc2440;

/**
 * @author Nguyen Quoc An - s3938278
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import javax.sound.midi.Soundbank;

public class ShoppingCart {
    private final static double BASE_FEE = 0.1;
    private Set<String> shoppingCart;
    private String name; //Assume cart have different and unique name

    public ShoppingCart() {
        this.shoppingCart = new HashSet<String>();
        this.name = Integer.toString(ShoppingCartList.getCartCount()+1);
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
        if (ShoppingCartList.getShoppingCartList().size()==0){
            System.out.println("There are no shopping cart yet.");
        }
        System.out.println("Shopping cart sorted by weight (descending order):\n");
        for (ShoppingCart s: ShoppingCart.sortShoppingCartByWeight()){
            System.out.println(s.toString());
            System.out.println();
        }
    }

    @Override
    public String toString(){
        return String.format("Cart number: %s, Weight: %.1f, Total Price: %.1f, Product: %s", this.name, this.calculateWeight(),this.cartAmount(),this.shoppingCart.toString());
    }

    public static void addProductToCart() throws Exception{
        Scanner scanner = new Scanner(System.in);
        String name;
        String productName;
        boolean cartFound = false;
        System.out.println("Enter Shopping cart name: ");
        name = scanner.nextLine();
        for (ShoppingCart s: ShoppingCartList.getShoppingCartList()){
            if (s.getName().equals(name)){
                System.out.println("Enter Product Name to add to shopping cart");
                productName = scanner.nextLine();
                // s.addItem(productName);
                if (s.addItem(productName)){
                    System.out.println("Added "+productName+" to cart: "+s.getName());
                }else{
                    System.out.println("Product not found.");
                }
                cartFound = true;
                break;
            }
        }
        if (cartFound == false){
            System.out.println("Cart not found.");
        }
    }

    public static void removeProductFromCart() throws Exception{
        Scanner scanner = new Scanner(System.in);
        String name;
        String productName;
        boolean cartFound = false;
        System.out.println("Enter Shopping cart name: ");
        name = scanner.nextLine();
        for (ShoppingCart s: ShoppingCartList.getShoppingCartList()){
            if (s.getName().equals(name)){
                System.out.println("Enter Product Name to remove from shopping cart");
                productName = scanner.nextLine();
                s.removeItem(productName);
                System.out.println("Removed "+productName+" from cart: "+s.getName());
                cartFound = true;
                break;
            }
        }
        if (cartFound == false){
            System.out.println("Cart not found.");
        }
    }
    
    public boolean addItem(String productName) throws Exception{
        for (Product product: Product.getProductList()){
            if (product.getName().equals(productName) && product.getQuantityAvailable()>0 && !shoppingCart.contains(productName)){
                shoppingCart.add(productName);
                product.setQuantityAvailable(product.getQuantityAvailable()-1);;    
                return true;
            }
        }
        return false;
    }

    public boolean removeItem(String productName) throws Exception{
        if (shoppingCart.contains(productName)){
            shoppingCart.remove(productName);
            for (Product product: Product.getProductList()){
                if (product.getName().equals(productName)){
                    product.setQuantityAvailable(product.getQuantityAvailable()+1);
                }
            }
            return true;
        }
        return false;
    }

    public double cartAmount(){
        double total = 0;
        for (String s: shoppingCart){
            for (Product p: Product.getProductList()){
                if(s.equals(p.getName()) && p instanceof DigitalProduct){
                    total += p.getPrice();
                }

                else if(s.equals(p.getName()) && p instanceof GiftableDigitalProduct){
                    total += p.getPrice();
                }

                else if(s.equals(p.getName()) && p instanceof PhysicalProduct){
                    total += p.getPrice() +((PhysicalProduct) p).getWeight() * BASE_FEE;
                }

                else if(s.equals(p.getName()) && p instanceof GiftablePhysicalProduct){
                    total += p.getPrice() +((GiftablePhysicalProduct) p).getWeight() * BASE_FEE;
                }
            }
        }
        return total;
    }

    public double calculateWeight(){
        double totalWeight =0;
        for (String s: shoppingCart){
            for (Product p: Product.getProductList()){
                if(s.equals(p.getName()) && p instanceof PhysicalProduct){
                    totalWeight += ((PhysicalProduct) p).getWeight();
                }else if (s.equals(p.getName()) && p instanceof GiftablePhysicalProduct){
                    totalWeight += ((GiftablePhysicalProduct) p).getWeight();
                }
            }
        }
        return totalWeight;
    }
    
    public static ArrayList<ShoppingCart> sortShoppingCartByWeight(){
        ArrayList<ShoppingCart> returnSet;
        returnSet = (ArrayList<ShoppingCart>) ShoppingCartList.getShoppingCartList().clone(); // Have to clone, otherwise it change the reference not the value
        Collections.sort(returnSet,new CartComparator());
        return returnSet;
    }

    // Getters and Setters

    public Set<String> getShoppingCart(){
        return shoppingCart;
    }

    public static double getBASE_FEE(){
        return BASE_FEE;
    }

    public void setShoppingCart(Set<String> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
