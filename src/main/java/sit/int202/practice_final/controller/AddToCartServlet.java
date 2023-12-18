package sit.int202.practice_final.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.practice_final.models.Cart;
import sit.int202.practice_final.models.CustomerItem;
import sit.int202.practice_final.repositories.CustomerRepository;
import sit.int202.practice_final.entities.Customer;

import java.io.IOException;

@WebServlet(name = "AddToCartServlet", value = "/093/add-to-cart")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String customerNumber = request.getParameter("customerNumber");
        CustomerRepository customerRepository = new CustomerRepository();
        Customer customerAdd = customerRepository.find(customerNumber);
        Cart<String, CustomerItem> cart = (Cart) session.getAttribute("cart");
        if (cart == null){
            cart = new Cart<>();
            request.getSession().setAttribute("cart",cart);
        }
        if (customerAdd != null){
            System.out.println(customerAdd.getCustomerName());
            cart.addItem(String.valueOf(customerAdd.getCustomerNumber()), new CustomerItem(customerAdd));
        }
        response.sendRedirect(request.getContextPath() + "/093/customer-list");
    }
}
 
