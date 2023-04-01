package com.cosc2440;

public class GiftablePhysicalProduct extends PhysicalProduct implements Gifts{
    private String giftMessage;

    public GiftablePhysicalProduct(String Name, String Description, int quantityAvailable, double price, double weight, String giftMessage)
            throws Exception {
        super(Name, Description, quantityAvailable, price, weight);
        this.giftMessage = giftMessage;
    }

    // Getters and Setters
    @Override
    public String toString(){
        return String.format("GIFTABLE PHYSICAL - %s", this.getName());
    }

    @Override
    public void setMessage(String msg) {
        this.giftMessage = msg;
    }

    @Override
    public String getMessage() {
        return this.giftMessage;
    }
}
