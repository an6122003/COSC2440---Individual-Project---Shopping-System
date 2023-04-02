package com.cosc2440;

/**
 * @author Nguyen Quoc An - s3938278
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GiftsMessageTest {
    @Test
    public void setAndGetMessageTest() throws Exception{
        GiftableDigitalProduct product1 = new GiftableDigitalProduct("name","Description", 10, 10,"msg");
        product1.setMessage("msg");
        assertEquals("msg", product1.getMessage());
    }
}
