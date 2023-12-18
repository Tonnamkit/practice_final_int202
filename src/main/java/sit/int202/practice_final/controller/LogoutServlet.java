package sit.int202.practice_final.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/093/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null || session.getAttribute("username") != null){
            session.removeAttribute("username");
        }
        response.sendRedirect(request.getContextPath() + "/093/login-form");
    }
}
 
