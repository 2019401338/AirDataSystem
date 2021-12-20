package service;

import dao.AirlineDaoImpl;
import dao.AirlineDao;
import pojo.EchartsBean;
import pojo.PageBean;
import service.imp.AirlineService;


import java.util.List;

public class AirlineServiceImpl implements AirlineService {
    private AirlineDao airlineDao=new AirlineDaoImpl();

    @Override
    public List<EchartsBean> querryAllAirlline() {
        return airlineDao.queryAllAirline();
    }

    @Override
    public PageBean<EchartsBean> queryAirlineByPage(int currentPage, int pageSize) {
        List<EchartsBean> echartsBeans=airlineDao.queryAirlineByPage(currentPage,pageSize);
        int total = airlineDao.getTotalRecords();
        PageBean<EchartsBean> pageBean=new PageBean<>();
        pageBean.setPageSize(pageSize);
        pageBean.setTotalRecords(total);
        pageBean.setCurrentPageNum(currentPage);
        pageBean.setList(echartsBeans);
        return pageBean;
    }
}
