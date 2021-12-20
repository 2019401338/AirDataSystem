package service;

import dao.AircraftDaoImpl;
import dao.AircraftDao;
import pojo.EchartsBean;
import pojo.PageBean;
import service.imp.AircraftService;

import java.util.List;

public class AircraftServiceImpl implements AircraftService {
    private AircraftDao aircraftDao=new AircraftDaoImpl();

    @Override
    public List<EchartsBean> querryAllAircraft() {
//        System.out.println(aircraftDao.queryAllAircraft());
        return aircraftDao.queryAllAircraft();
    }

    @Override
    public PageBean<EchartsBean> queryAircraftByPage(int currentPage, int pageSize) {
        List<EchartsBean> echartsBeans=aircraftDao.queryAircraftByPage(currentPage,pageSize);
        int total = aircraftDao.getTotalRecords();
        PageBean<EchartsBean> pageBean=new PageBean<>();
        pageBean.setPageSize(pageSize);
        pageBean.setTotalRecords(total);
        pageBean.setCurrentPageNum(currentPage);
        pageBean.setList(echartsBeans);
        return pageBean;
    }
}
