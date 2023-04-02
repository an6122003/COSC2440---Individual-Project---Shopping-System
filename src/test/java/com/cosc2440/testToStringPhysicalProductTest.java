package com.cosc2440;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class testToStringPhysicalProductTest {
    @Test
    public void testToStringPhysicalProduct() throws Exception{
        PhysicalProduct product = new PhysicalProduct("product","Description",10,1,10);
        assertEquals("PHYSICAL - product", product.toString());
    }
}
