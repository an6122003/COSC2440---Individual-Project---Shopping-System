package com.cosc2440;

/**
 * @author Nguyen Quoc An - s3938278
 */

public class PhysicalProduct extends Product{
    private double weight;
    private String giftMessage;

    public PhysicalProduct(String Name, String Description, int quantityAvailable, double price, double weight) throws Exception {
        super(Name, Description, quantityAvailable, price);
        this.weight = weight;
    }

    @Override
    public String toString(){
        return String.format("PHYSICAL - %s", this.getName());
    }

    // Getters and Setters
    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
