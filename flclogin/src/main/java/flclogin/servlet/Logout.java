package flclogin.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout"})
public class Logout extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        //当用户点击退出按钮时，登录人数减1
        HttpSession httpSession=request.getSession();
        httpSession.invalidate();
        Integer logincount=(Integer) httpSession.getServletContext().getAttribute("logincount");
        httpSession.getServletContext().setAttribute("logincount",logincount-1);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
