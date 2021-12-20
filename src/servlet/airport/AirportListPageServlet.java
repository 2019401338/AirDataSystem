package servlet.airport;

import pojo.Airport;
import pojo.PageBean;
import service.AirportServiceImpl;
import service.imp.AirportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AirportListPageServlet",urlPatterns = "/airportlist")
public class AirportListPageServlet extends HttpServlet {
    private AirportService airportService=new AirportServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        //取当前页
        String currentPage = req.getParameter("currentPage");
//        String stanumConditon = req.getParameter("airport_Cname");
//        String szCondtionSql = "";
//        if(stanumConditon!=null){
//            szCondtionSql+=" where airport_Cname like '%"+stanumConditon+"%' ";
//        }
        //第一次访问，默认currentPage 访问第一页
        if (currentPage == null) {
            currentPage = "1";
        }
        Integer currentPageNum = Integer.parseInt(currentPage);
        //页面大小暂设置成固定值10

        //分页查询所有
        PageBean<Airport> pageBean = airportService.queryAirportByPage(currentPageNum, 10);
        //servlet重在业务逻辑，取值传值 jsp侧重于页面显示
        req.setAttribute("page", pageBean);
//        req.setAttribute("c",stanumConditon);
        //请求转发
        req.getRequestDispatcher("airportlistpage.jsp").forward(req, resp);
    }
}
