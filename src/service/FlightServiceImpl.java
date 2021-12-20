package service;

import dao.FlightDaoImpl;
import dao.FlightDao;
import pojo.Flight;
import service.imp.FlightService;

import java.util.List;

public class FlightServiceImpl implements FlightService {
    private FlightDao flightDao=new FlightDaoImpl();
    @Override
    public List<Flight> queryAllFlight() {
        return flightDao.queryAllFlight();
    }
}
