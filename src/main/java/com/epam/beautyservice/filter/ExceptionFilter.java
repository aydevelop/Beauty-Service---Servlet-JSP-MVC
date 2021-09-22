package com.epam.beautyservice.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "Exception")
public class ExceptionFilter implements Filter {
    private final Logger logger = Logger.getLogger(ExceptionFilter.class);

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        try {
            chain.doFilter(request, response);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            ex.printStackTrace();

        }
    }
}