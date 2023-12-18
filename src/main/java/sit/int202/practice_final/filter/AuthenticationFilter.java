package sit.int202.practice_final.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter", servletNames = {"customerList"}) // urlPatterns = "/*" for check all servlet
public class AuthenticationFilter implements Filter {
    private FilterConfig filterConfig;
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException,IOException{
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession(false);
        System.out.println("This is Filter Authed");
        if (session==null ||session.getAttribute("username")==null) {
            request.setAttribute("message","Please Login First!!");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {

    }
}
 
