package com.cosc2440;

/**
 * @author Nguyen Quoc An - s3938278
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ToStringDigitalProductTest {
    @Test
    public void testToStringDigitalProduct() throws Exception{
        DigitalProduct product = new DigitalProduct("digital product","Description",10,1);
        assertEquals("DIGITAL - digital product", product.toString());
    }
}
