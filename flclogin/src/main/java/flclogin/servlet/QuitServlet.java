package flclogin.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "QuitServlet", urlPatterns = {"/quit"})
public class QuitServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        //当用户离开当前网页时，销毁session
        System.out.println("一个用户离开了！");
        HttpSession httpSession=request.getSession();
        httpSession.invalidate();
    }
}
