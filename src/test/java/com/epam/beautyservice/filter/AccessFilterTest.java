package com.epam.beautyservice.filter;

import junit.framework.TestCase;
import org.junit.Test;

public class AccessFilterTest extends TestCase {
    @Test
    public void testProtectedRoute() {
        AccessFilter context = new AccessFilter();
        assertTrue(context.protectedRoute.isEmpty());
    }
}