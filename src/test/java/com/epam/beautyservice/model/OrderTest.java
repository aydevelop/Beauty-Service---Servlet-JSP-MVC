package com.epam.beautyservice.model;

import junit.framework.TestCase;
import org.junit.Test;

public class OrderTest extends TestCase {
    @Test
    public void testOrder() {
        Order order = new Order();
        assertNull(order.getService());
    }
}