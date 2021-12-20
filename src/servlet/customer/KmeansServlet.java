package servlet.customer;

import pojo.Kmeans;
import service.KmeansServiceImpl;
import service.imp.KmeansService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "KmeansServlet",urlPatterns = "/kmeanslist")
public class KmeansServlet extends HttpServlet {
    private KmeansService kmeansService=new KmeansServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Kmeans> list=kmeansService.queryAllKmeans();
        req.setAttribute("kmeanslist",list);
        req.getRequestDispatcher("kmeanslist.jsp").forward(req,resp);
    }
}
