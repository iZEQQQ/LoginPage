package pl.edu.pjwstk.login.filter;


import pl.edu.pjwstk.login.controllers.UserContext;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//TODO poprawic filter by dzialal i nie blokowal css
//@WebFilter("*")
public class AutFilter implements Filter {
    @Inject
    UserContext userContext;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (userContext.isLogged() || ((HttpServletRequest) request).getServletPath().equals("/sign_done.xhtml") || ((HttpServletRequest) request).getServletPath().equals("/sign_up.xhtml")) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("sign_done.xhtml");
        }



    }
}
