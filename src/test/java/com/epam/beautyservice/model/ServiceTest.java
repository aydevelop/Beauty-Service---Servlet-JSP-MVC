package com.epam.beautyservice.model;

import junit.framework.TestCase;
import org.junit.Test;

public class ServiceTest extends TestCase {
    @Test
    public void testService() {
        Service service = new Service();
        assertEquals(service.getMasters().size(), 0);
    }
}