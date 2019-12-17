package pl.edu.pjwstk.login.filter;


import pl.edu.pjwstk.login.controllers.UserContext;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*")
public class AutFilter implements Filter {
    @Inject
    UserContext userContext;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String path = ((HttpServletRequest) request).getServletPath();
        if (userContext.isLogged()
                || path.equals("/sign_done.xhtml")
                || path.equals("/sign_up.xhtml")
                || path.endsWith("ln=css")
                || path.endsWith("ln=img")
                || path.endsWith("ln=js")) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("sign_done.xhtml");
        }


    }
}
