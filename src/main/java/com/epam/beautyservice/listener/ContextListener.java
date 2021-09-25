package com.epam.beautyservice.listener;

import com.epam.beautyservice.utils.MailJob;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.jsp.jstl.core.Config;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@WebListener
public class ContextListener implements ServletContextListener, HttpSessionListener {
    private String defaultLocale = "";
    private ScheduledExecutorService scheduler;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();
        initLog4J(servletContext);

        String host = servletContext.getInitParameter("host");
        backgroundJobInit(host);

        String localesValue = servletContext.getInitParameter("Locales");
        if (localesValue != null && localesValue.isEmpty() == false) {

            List<String> locales = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(localesValue);
            while (st.hasMoreTokens()) {
                String localeName = st.nextToken();
                locales.add(localeName);
            }

            servletContext.setAttribute("locales", locales);
            if (!locales.isEmpty()) {
                defaultLocale = locales.get(0);
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        scheduler.shutdownNow();
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        Config.set(session, "javax.servlet.jsp.jstl.fmt.locale", defaultLocale);
        session.setAttribute("defaultLocale", defaultLocale);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        //session destroyed
    }

    private void initLog4J(ServletContext servletContext) {
        try {
            PropertyConfigurator.configure(servletContext.getRealPath("WEB-INF/log4j.properties"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void backgroundJobInit(String host) {
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new MailJob(host), 0, 5, TimeUnit.SECONDS);
    }
}
