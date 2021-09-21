package com.epam.beautyservice.listener;

import junit.framework.TestCase;
import org.junit.Test;

public class ContextListenerTest extends TestCase {
    @Test
    public void testDefaultLocale() {
        ContextListener context = new ContextListener();
        assertEquals(context.defaultLocale, "");
    }
}