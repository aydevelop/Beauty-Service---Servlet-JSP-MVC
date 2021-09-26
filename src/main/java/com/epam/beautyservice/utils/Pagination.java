package com.epam.beautyservice.utils;

import com.epam.beautyservice.model.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Pagination code for services
 */
public class Pagination {
    private Pagination() {
    }

    public static List<Service> Generation(HttpServletRequest request, List<Service> services) {
        request.setAttribute("total", services.size());
        int currentPage = 1;
        int recordsPerPage = 3;
        int recordsPerPageAll = 3;

        String strPerPage = request.getServletContext().getInitParameter("RecordsPerPage");
        if (strPerPage != null) {
            recordsPerPage = Integer.parseInt(strPerPage);
            recordsPerPageAll = Integer.parseInt(strPerPage);
        }

        String strRecordsPerPage = request.getParameter("recordsPerPage");
        if (strRecordsPerPage != null) {
            recordsPerPage = Integer.parseInt(strRecordsPerPage);
        }

        String strCurrentPage = request.getParameter("currentPage");
        if (strCurrentPage != null) {
            currentPage = Integer.parseInt(strCurrentPage);
        }

        int size = services.size();
        int nOfPages = size / recordsPerPage;
        if (nOfPages > 1) {
            if (recordsPerPage != 1) {
                nOfPages++;
            }
        } else {
            if (size != recordsPerPage) {
                nOfPages++;
            }
        }

        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);
        request.setAttribute("recordsPerPageAll", recordsPerPageAll);
        services = services.stream().skip((currentPage - 1) * recordsPerPage)
                .limit(recordsPerPage).collect(Collectors.toList());

        return services;
    }
}
