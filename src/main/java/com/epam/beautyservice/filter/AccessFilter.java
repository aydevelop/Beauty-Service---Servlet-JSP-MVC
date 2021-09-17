package com.epam.beautyservice.filter;

import com.epam.beautyservice.utils.Router;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class AccessFilter implements Filter {
    Map<String, String> protectedRoute = new HashMap<String, String>();

    public void init(FilterConfig config) throws ServletException {
        //disabled for testing
        //initRoute(config, "admin");
        //initRoute(config, "master");
        //initRoute(config, "client");
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String url = ((HttpServletRequest) request).getRequestURL().toString();
        String segment = Router.getSegment(url);

        if (isAllowed(segment, request)) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletRequest) request).getSession().setAttribute("error", "Access is denied");
            request.getRequestDispatcher("/auth/login").forward(request, response);
        }
    }

    private boolean isAllowed(String segment, ServletRequest request) {
        if (protectedRoute.containsKey(segment)) {
            String route = protectedRoute.get(segment);

            HttpSession session = ((HttpServletRequest) request).getSession(false);
            if (session != null) {
                Object role = session.getAttribute("role");
                if (role != null) {
                    if (((String) role).equals(route)) {
                        return true;
                    }
                }
            }
            return false;
        }

        return true;
    }

    private void initRoute(FilterConfig config, String role) {
        String line = config.getInitParameter(role);
        if (line != null) {
            List<String> list = asList(line.split(","));
            for (String route : list) {
                protectedRoute.put(route, role);
            }
        }
    }
}