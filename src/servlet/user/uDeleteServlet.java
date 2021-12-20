package servlet.user;

import service.UserServiceImpl;
import service.imp.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "uDeleteServlet",urlPatterns = "/udelete")
public class uDeleteServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //取参
        String username = req.getParameter("username");
        boolean flag = userService.deleteUserByStanum(username);
        if (flag) {
            resp.sendRedirect("ulistpage");
        }else {
            resp.sendRedirect("index");
        }
    }
}
