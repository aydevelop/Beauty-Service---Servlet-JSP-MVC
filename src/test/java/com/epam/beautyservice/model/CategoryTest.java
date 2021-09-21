package com.epam.beautyservice.model;

import junit.framework.TestCase;
import org.junit.Test;

public class CategoryTest extends TestCase {
    @Test
    public void testGetName() {
        Category category = new Category();
        category.setName_en("enName");

        assertEquals(category.getName(""), category.getName_en());
    }
}