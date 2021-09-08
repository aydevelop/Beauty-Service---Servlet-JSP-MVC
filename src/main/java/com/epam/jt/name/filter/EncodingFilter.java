package com.epam.jt.name.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/")
public class EncodingFilter implements Filter {
    private String encoding;
    private String contentType;

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        response.setContentType(contentType);
        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
        ServletContext context = fConfig.getServletContext();
        encoding = context.getInitParameter("encoding");
        contentType = context.getInitParameter("content-type");
    }
}
