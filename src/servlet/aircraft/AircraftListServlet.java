package servlet.aircraft;

import pojo.EchartsBean;
import pojo.PageBean;
import service.AircraftServiceImpl;
import service.imp.AircraftService;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AircraftListServlet",urlPatterns = "/aircraftlist")
public class AircraftListServlet extends HttpServlet {
   private AircraftService aircraftService=new AircraftServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询所有飞机型号
        List<EchartsBean> list = aircraftService.querryAllAircraft();
//        System.out.println(list);
        //把不满信息放在request对象里面
//        req.setAttribute("aircraftlist",list);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=ust-8");
        String currentPage = req.getParameter("currentPage");
        if(currentPage==null){
            currentPage="1";
        }
        Integer currentPageNum = Integer.parseInt(currentPage);
        PageBean<EchartsBean> pageBean=aircraftService.queryAircraftByPage(currentPageNum,12);
        req.setAttribute("page",pageBean);

        String json = JSONObject.toJSONString(list);
//        System.out.println(json);
        req.setAttribute("tulist",json);
        //请求转发
        req.getRequestDispatcher("aircraftlist.jsp").forward(req,resp);
    }
}
