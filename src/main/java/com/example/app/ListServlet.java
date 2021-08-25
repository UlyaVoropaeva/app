package com.example.app;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "listServlet", value = "/list")
public class ListServlet extends HttpServlet {


    public void init() {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Model model = Model.getInstance();
        List<Product> product = new ArrayList<>();
        product.addAll(model.getProducts());
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "List products!" + "</h1>");

        for (Product p : product) {
            out.println("<p> Name: " + p.getName() + "</p>");
            out.println("<p>< Price: " + p.getPrice() + "</p>");
        }
        out.println("</body></html>");

    }

    public void destroy() {
    }

}
