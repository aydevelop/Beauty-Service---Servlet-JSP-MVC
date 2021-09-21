package com.epam.beautyservice.utils;

import junit.framework.TestCase;
import org.junit.Test;

import javax.servlet.jsp.JspException;
import java.io.IOException;


public class FoundedTagTest extends TestCase {
    @Test(expected = Exception.class)
    public void testDoTag() throws JspException, IOException {
        FoundedTag ft = new FoundedTag();
        ft.doTag();
    }
}