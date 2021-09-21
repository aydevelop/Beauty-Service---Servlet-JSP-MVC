package com.epam.beautyservice.model;

import junit.framework.TestCase;
import org.junit.Test;

public class UserTest extends TestCase {
    @Test
    public void testRole() {
        User user = new User();
        user.setRating(10);

        assertEquals(user.getRating(), 10);
    }
}