package com.epam.beautyservice.utils;

import junit.framework.TestCase;
import org.junit.Test;

public class SecurityTest extends TestCase {
    @Test
    public void testGetSHA512Password() {
        String hash = "b6bd34dbf7d1923ee81b3f04189fb29ae87fde7c1c5bd9de69c6baef57609250f12e8cd19239b33e79ae85c1ed59b188fbef5863f7f78296a29448d211eac6d7";
        assertEquals(Security.getSHA512Password("1234"), hash);
    }
}