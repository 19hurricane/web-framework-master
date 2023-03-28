package flclogin.Filter;

import flclogin.entity.User;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = "/statics/main.jsp")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        //过滤器如果没有当前用户的信息，则认为未登录，不可直接访问登录成功的界面
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        User user=(User)request.getSession().getAttribute("user");
        System.out.println("通过了过滤器");
        if(user==null)
        {
            System.out.println("还没登录！");
            request.getSession().setAttribute("islogin",0);
            response.sendRedirect("/");
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
