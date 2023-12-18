package sit.int202.practice_final.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.practice_final.entities.Customer;

import sit.int202.practice_final.repositories.CustomerRepository;

import java.io.IOException;
import java.util.List;

import static sit.int202.practice_final.util.Utill.isNullOrEmpty;

@WebServlet(name = "customerList", value = "/093/customer-list")
public class CustomerList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerRepository customerRepository = new CustomerRepository();
        List<Customer> customerList = customerRepository.findAll();
        request.setAttribute("customers", customerList);
        request.getRequestDispatcher("/customerList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerRepository customerRepository = new CustomerRepository();
        String name = request.getParameter("name");
        if (!isNullOrEmpty(name)) {
            Customer findCustomer = customerRepository.findByName(name);
            if (findCustomer != null) {
                request.setAttribute("customer", findCustomer);
                request.setAttribute("message", null);
            }else {
                request.setAttribute("message", "Not Found");
                request.setAttribute("customers", customerRepository.findAll());
            }
        } else {
            request.setAttribute("message", "Please Fill Name");
            request.setAttribute("customers", customerRepository.findAll());
        }
        request.getRequestDispatcher("/customerList.jsp").forward(request, response);

    }
}
 
