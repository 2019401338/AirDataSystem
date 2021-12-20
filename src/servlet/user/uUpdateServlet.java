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

@WebServlet(name = "uUpdateServlet",urlPatterns = "/uupdate")
public class uUpdateServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //取参数值
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        Integer id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String position = req.getParameter("position");

        User user = new User(id, username, password,position);

        //实现修改逻辑
        boolean flag = userService.updateUser(user);
        if (flag) {
            //修改成功
            resp.sendRedirect("ulistpage");
        } else {
            //修改失败
            resp.sendRedirect("uupdate.jsp");
        }
    }
}
