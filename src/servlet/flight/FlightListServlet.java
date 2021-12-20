package servlet.flight;

import pojo.Flight;
import service.FlightServiceImpl;
import service.imp.FlightService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FlightListServlet",urlPatterns = "/flighttable")
public class FlightListServlet extends HttpServlet {
    private FlightService flightService=new FlightServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Flight> list=flightService.queryAllFlight();
        req.setAttribute("flightlist",list);
        req.getRequestDispatcher("flightlist.jsp").forward(req,resp);
    }
}
