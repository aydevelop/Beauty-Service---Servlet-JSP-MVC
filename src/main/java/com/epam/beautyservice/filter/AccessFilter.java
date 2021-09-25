package com.epam.beautyservice.filter;

import com.epam.beautyservice.utils.Router;
import com.epam.beautyservice.utils.Translate;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class AccessFilter implements Filter {
    Map<String, String> protectedRoute = new HashMap<>();

    public void init(FilterConfig config) throws ServletException {
        initRoute(config, "admin");
        initRoute(config, "master");
        initRoute(config, "client");
    }
    
    @Override
    public void destroy() {
        //destroy filter
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String url = ((HttpServletRequest) request).getRequestURL().toString();
        String segment = Router.getSegment(url);

        if (isAllowed(segment, request)) {
            chain.doFilter(request, response);
        } else {
            HttpSession session = ((HttpServletRequest) request).getSession();
            session.setAttribute("error", Translate.get("access_denied", session));
            request.getRequestDispatcher("/auth/login").forward(request, response);
        }
    }

    private boolean isAllowed(String segment, ServletRequest request) {
        if (protectedRoute.containsKey(segment)) {
            String route = protectedRoute.get(segment);

            HttpSession session = ((HttpServletRequest) request).getSession(false);
            if (session != null) {
                Object role = session.getAttribute("role");
                if (role != null && (role).equals(route)) {
                    return true;
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