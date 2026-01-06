package com.voyageconnect.controller;

import com.voyageconnect.model.Destination;
import com.voyageconnect.service.DestinationService;
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

import org.springframework.beans.factory.annotation.Autowired;

@WebServlet("/admin/destinations")
public class AdminDestinationServlet extends HttpServlet {

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
        req.getRequestDispatcher("/WEB-INF/views/admin/manage-destinations.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("delete".equals(action)) {
            Long id = Long.parseLong(req.getParameter("id"));
            destinationService.deleteDestination(id);
        } else {
            String nom = req.getParameter("nom");
            String pays = req.getParameter("pays");
            String ville = req.getParameter("ville");
            String description = req.getParameter("description");
            String image = req.getParameter("image");

            Destination destination = new Destination(nom, pays, ville, description, image);
            destinationService.createDestination(destination);
        }
        resp.sendRedirect(req.getContextPath() + "/admin/destinations");
    }
}
