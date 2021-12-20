package filter;

import pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter",urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //转换类型
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse) resp;

        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("user");
        String path=request.getRequestURI();


        if (path.endsWith(".js")||path.endsWith(".css")||path.endsWith(".jpg")||path.endsWith(".png")){
            chain.doFilter(req,resp);
            return;
        }
        if(user!=null){
            chain.doFilter(req,resp);
            return;
        }else {
            if (path.endsWith("login.jsp") || path.endsWith("register.html") || path.endsWith("login") || path.endsWith("register")) {
                chain.doFilter(req, resp);
                return;
            } else {
                response.sendRedirect("login.jsp");
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
