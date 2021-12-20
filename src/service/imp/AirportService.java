package service.imp;

import pojo.Airport;
import pojo.PageBean;

public interface AirportService {
    public PageBean<Airport> queryAirportByPage(int currentPage, int pageSize);
}
