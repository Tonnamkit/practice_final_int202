package sit.int202.practice_final.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/093/login-form")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("Tonnam") && password.equals("093")){
            HttpSession session = request.getSession(true);
            session.setAttribute("username",username);
            request.setAttribute("message","Login Successfully");
        }else {
            request.setAttribute("message","Wrong UserName or Password");
        }
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
}
 
