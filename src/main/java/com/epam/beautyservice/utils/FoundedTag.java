package com.epam.beautyservice.utils;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Calendar;

public class FoundedTag extends SimpleTagSupport {
    private String year;

    public FoundedTag() {
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public void doTag() throws JspException, IOException {
        try {
            getJspContext().getOut().write(year + " - " + Calendar.getInstance().get(Calendar.YEAR));
        } catch (Exception e) {

        }
    }
}
