package com.epam.beautyservice.utils;

import com.epam.beautyservice.model.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

public class Pagination {
    public static List<Service> Generation(HttpServletRequest request, List<Service> services) {
        request.setAttribute("total", services.size());
        int currentPage = 1;
        int recordsPerPage = 3;

        String strPerPage = request.getServletContext().getInitParameter("RecordsPerPage");
        if (strPerPage != null) {
            recordsPerPage = Integer.parseInt(strPerPage);
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
        int nOfPages = services.size() / recordsPerPage;
        if (nOfPages > 0 && size % nOfPages > 0) {
            nOfPages++;
        }

        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);
        services = services.stream().skip((currentPage - 1) * recordsPerPage)
                .limit(recordsPerPage).collect(Collectors.toList());

        return services;
    }
}
