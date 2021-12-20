package servlet.user;

import pojo.User;
import service.UserServiceImpl;
import service.imp.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "uLoadServlet",urlPatterns = "/uload")
public class uLoadServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username=req.getParameter("username");
        //根据stanum查询单个
        User user = userService.queryOneUserById(username);
        req.setAttribute("u",user);
        //请求转发
        req.getRequestDispatcher("uupdate.jsp").forward(req,resp);

    }
}
