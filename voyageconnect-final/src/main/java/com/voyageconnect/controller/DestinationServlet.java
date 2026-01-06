package com.voyageconnect.controller;

import com.voyageconnect.model.Destination;
import com.voyageconnect.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/destinations")
public class DestinationServlet extends HttpServlet {

    @Autowired
    private DestinationService destinationService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        context.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Destination> destinations = destinationService.getAllDestinations();
        req.setAttribute("destinations", destinations);
        req.getRequestDispatcher("/WEB-INF/views/destinations.jsp").forward(req, resp);
    }
}
