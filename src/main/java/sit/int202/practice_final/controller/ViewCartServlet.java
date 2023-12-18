package sit.int202.practice_final.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.practice_final.models.Cart;
import sit.int202.practice_final.models.CustomerItem;

import java.io.IOException;

@WebServlet(name = "ViewCartServlet", value = "/093/view-cart")
public class ViewCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null|| session.getAttribute("cart") == null){
            request.setAttribute("message","No Customer Add");
        }else{
            Cart<String, CustomerItem> cart = (Cart) session.getAttribute("cart");
            request.setAttribute("customers", cart.getAllItem());
        }
        request.getRequestDispatcher("/show-customer.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
 
