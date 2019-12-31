package pl.edu.pjwstk.login.filter;


import pl.edu.pjwstk.login.controllers.UserContext;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/auction/branch_edit.xhtml","/auction/category_edit.xhtml"})
public class UserFilter implements Filter {
    @Inject
    UserContext userContext;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String path = ((HttpServletRequest) request).getServletPath();
        String query = ((HttpServletRequest) request).getQueryString();

        if (userContext.getAdminRole()
                || path.equals("/auction/branch_edit.xhtml")
                || path.equals("/auction/category_edit.xhtml")
                || query != null && query.endsWith("ln=css")
                || query != null && query.endsWith("ln=img")
                || query != null && query.endsWith("ln=js")) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("logged_welcome.xhtml");
        }


    }
}
