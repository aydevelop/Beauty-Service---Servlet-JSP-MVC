package com.epam.beautyservice.utils;

import junit.framework.TestCase;
import org.junit.Test;

public class ValidatorTest extends TestCase {

    @Test
    public void testIsDateValid() {
        assertTrue(Validator.isDateValid("2010-10-10"));
    }

    @Test
    public void testIsDateValid2() {
        assertTrue(Validator.isDateValid("12010-10-10"));
    }

    public void testCheckEmailAndCheckPassword() {
        Validator v = new Validator();
        v.checkEmail("2@mail.com");
        v.checkPassword("1234");

        assertTrue(v.getError().length() == 0);
    }
}