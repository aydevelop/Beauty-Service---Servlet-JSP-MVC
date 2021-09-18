package com.epam.beautyservice.controller.home.action;

import com.epam.beautyservice.controller.Action;
import com.epam.beautyservice.controller.Base;
import com.epam.beautyservice.model.Service;
import com.epam.beautyservice.utils.Pagination;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class HomeServiceSortPostAction extends Base implements Action {
    public HomeServiceSortPostAction(String view, HttpServletRequest request, HttpServletResponse response) {
        super(view, request, response);
    }

    @Override
    public void execute() throws IOException {
        List<String> categories = Parse("categories");
        List<String> masters = Parse("masters");
        List<Service> services = db.getServices().queryAllWithMasterAndCategory();

        if (categories.size() > 0) {
            services = services.stream().filter(s -> categories.contains(s.getCategoryId())).collect(Collectors.toList());
        }


        if (masters.size() > 0) {
            services = services.stream().filter(s -> {
                for (String master : masters) {
                    List<String> serviceMasters = s.getMasters();
                    if (serviceMasters.contains(master)) {
                        return true;
                    }
                }
                return false;
            }).collect(Collectors.toList());
        }

        ;
        services = Pagination.Generation(request, services);
        request.setAttribute("services", services);
        fragment("services", request, response);
    }

    private List<String> Parse(String key) {
        String line = request.getParameter(key);
        List<String> res = new ArrayList<>();

        if (line != null && line.length() > 0) {
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                res.add(st.nextToken());
            }
        }

        return res;
    }
}
