package com.cosc2440;

public class GiftableDigitalProduct extends DigitalProduct implements Gifts{
    private String giftMessage;

    public GiftableDigitalProduct(String Name, String Description, int quantityAvailable, double price, String giftMessage)
            throws Exception {
        super(Name, Description, quantityAvailable, price);
        this.giftMessage = giftMessage;
    }    

    // Getters and Setters
    @Override
    public String toString(){
        return String.format("GIFTABLE DIGITAL - %s", this.getName());
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
