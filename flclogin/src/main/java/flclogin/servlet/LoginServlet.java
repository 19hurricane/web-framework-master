package flclogin.servlet;

import flclogin.db.Database;
import flclogin.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sql = "select *from user where " + " username='" + username + "' and  password='" + password + "' ";
        System.out.println(sql);
        Database database = new Database();
        ResultSet resultSet = database.select(sql);
        try {
            if (resultSet.next()) {
                //如果登录成功，登录人数+1
                if (resultSet.getString("username").equals(username) && resultSet.getString("password").equals(password)) {
                    User user = new User(username, password);
                    HttpSession httpSession=request.getSession();
                    httpSession.setAttribute("user", user);
                    ServletContext servletContext=httpSession.getServletContext();
                    Integer logincount=(Integer) servletContext.getAttribute("logincount");
                    if(logincount==null)
                        logincount=0;
                    servletContext.setAttribute("logincount",logincount+1);
                    response.sendRedirect("statics/main.jsp");
                }
            } else {
                response.sendRedirect("/");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = this.getServletContext();
        Integer sum = 0;
        context.setAttribute("count", sum);
    }
}
