package com.epam.beautyservice.utils;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Calendar;

/**
 * Example of a custom tag
 */
public class FoundedTag extends SimpleTagSupport {
    private String year;

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public void doTag() throws JspException, IOException {
        try {
            getJspContext().getOut().write(year + " - " + Calendar.getInstance().get(Calendar.YEAR));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
