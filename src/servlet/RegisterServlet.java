package servlet;

import pojo.User;
import service.UserServiceImpl;
import service.imp.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取参
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User qtUser=new User(username,password);
        boolean flag = userService.register(qtUser);
        //注册成功 需要跳转到登录页面，注册失败 需要 回到注册页面，继续注册
        if(flag){
            //重定向 就表示重新定位到一个地址
            resp.sendRedirect("login.jsp");
        }else{
            resp.sendRedirect("register.html");
        }
    }
}
