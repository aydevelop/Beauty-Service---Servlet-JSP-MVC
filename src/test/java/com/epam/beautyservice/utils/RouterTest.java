package com.epam.beautyservice.utils;

import junit.framework.TestCase;
import org.junit.Test;

public class RouterTest extends TestCase {
    @Test
    public void testGetSHA512Password() {
        assertEquals(Router.parse(null), "");
    }
}