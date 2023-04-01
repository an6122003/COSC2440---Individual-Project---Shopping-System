package com.cosc2440;

/**
 * @author Nguyen Quoc An - s3938278
 */

public class DigitalProduct extends Product{

    public DigitalProduct(String Name, String Description, int quantityAvailable, double price) throws Exception {
        super(Name, Description, quantityAvailable, price);
        //TODO Auto-generated constructor stub
    }
    
    @Override
    public String toString(){
        return String.format("DIGITAL - %s", this.getName());
    }

}
