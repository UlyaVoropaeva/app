package com.example.app;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.example.app.Model;
import com.example.app.Product;


@WebServlet (name = "listServlet", value = "/list")
public class ListServlet extends HttpServlet {

    private String message;

    public void init() {
        message = "List product!";
    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Model model = Model.getInstance();
        List<Product> product = model.getProducts();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/list.jsp");
        requestDispatcher.forward(request, response);

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

        request.setAttribute("Product", product);

    }


    public void destroy() {
    }

}
