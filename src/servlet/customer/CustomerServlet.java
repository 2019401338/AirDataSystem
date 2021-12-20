package servlet.customer;

import pojo.Customerinfor;
import pojo.PageBean;
import service.CustomerServiceImpl;
import service.imp.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customerlist")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService=new CustomerServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=ust-8");
        String currentPage = req.getParameter("currentPage");
        if(currentPage==null){
            currentPage="1";
        }
        Integer currentPageNum = Integer.parseInt(currentPage);
        PageBean<Customerinfor> pageBean=customerService.queryCustomerByPage(currentPageNum,12);
        req.setAttribute("page",pageBean);
//        System.out.println(pageBean);
        req.getRequestDispatcher("customerlist.jsp").forward(req,resp);
    }
}
