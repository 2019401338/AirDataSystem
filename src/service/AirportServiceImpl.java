package service;

import dao.AirportDaoImpl;
import dao.AirportDao;
import pojo.Airport;
import pojo.PageBean;
import service.imp.AirportService;

import java.util.List;

public class AirportServiceImpl implements AirportService {
    private AirportDao airportDao=new AirportDaoImpl();
    @Override
    public PageBean<Airport> queryAirportByPage(int currentPage, int pageSize) {
        List<Airport> airports = airportDao.queryAirportByPage(currentPage,pageSize);
        int total = airportDao.getTotalRecords();
        PageBean<Airport> pageBean = new PageBean<>();
        pageBean.setPageSize(pageSize);//设置页面大小
        pageBean.setTotalRecords(total);//设置总记录数
        pageBean.setCurrentPageNum(currentPage);//设置当前页
        pageBean.setList(airports);
        return pageBean;
    }
}
