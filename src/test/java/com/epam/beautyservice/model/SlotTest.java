package com.epam.beautyservice.model;

import junit.framework.TestCase;
import org.junit.Test;

public class SlotTest extends TestCase {
    @Test
    public void testSlot() {
        Slot slot = new Slot();
        slot.setName("myName");

        assertTrue(slot.toString().indexOf("myName") > 0);
    }
}