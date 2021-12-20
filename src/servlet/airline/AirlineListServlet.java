package servlet.airline;

import com.alibaba.fastjson.JSONObject;
import pojo.Customerinfor;
import pojo.EchartsBean;
import pojo.PageBean;
import service.AirlineServiceImpl;
import service.imp.AirlineService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AirlineListServlet",urlPatterns = "/airlinelist")
public class AirlineListServlet extends HttpServlet {
    private AirlineService airlineService=new AirlineServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<EchartsBean> list = airlineService.querryAllAirlline();

//        req.setAttribute("airlinelist",list);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=ust-8");
        String currentPage = req.getParameter("currentPage");
        if(currentPage==null){
            currentPage="1";
        }
        Integer currentPageNum = Integer.parseInt(currentPage);
        PageBean<EchartsBean> pageBean=airlineService.queryAirlineByPage(currentPageNum,12);
        req.setAttribute("page",pageBean);

        String json = JSONObject.toJSONString(list);
        //System.out.println(json);
        req.setAttribute("tulist",json);
        //请求转发
        req.getRequestDispatcher("airlinelist.jsp").forward(req,resp);
    }
}
