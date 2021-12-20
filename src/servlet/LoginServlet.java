package servlet;

import pojo.User;
import service.UserServiceImpl;
import service.imp.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 取前台参数
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User qtuser=new User(username,password);
        User htuser = userService.login(qtuser);

        // 判断登录是否成功
        if(htuser!=null){
            //登录成功
            HttpSession session = request.getSession();
            session.setAttribute("user",htuser);
            if(htuser.getPosition()==null){
                request.setAttribute("error","请先让管理员输入你的职位！");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
            else {
                if(htuser.getPosition().equals("用户")){
                    response.sendRedirect("index.jsp");
                }else if(htuser.getPosition().equals("管理员")){
                    response.sendRedirect("orindex.jsp");
                }
            }

        }else{
            //登录失败
            request.setAttribute("wrongText","用户名或密码错误!!!");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
