package com.epam.beautyservice.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private String encoding;
    private String contentType;

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
        //ServletContext context = fConfig.getServletContext();
        //encoding = context.getInitParameter("encoding");
        //contentType = context.getInitParameter("content-type");
    }
}
