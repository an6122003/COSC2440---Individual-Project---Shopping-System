package com.cosc2440;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.util.ArrayList;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

public class ConstructorNegativeQuantityTest {
    @Test 
    public void testConstructorNegativeQuantity() throws Exception {
        //Expect to throw an exception due to negative quantity
        assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Product product = new DigitalProduct("product","Description",-10,1);
            }
        });
    }
}
