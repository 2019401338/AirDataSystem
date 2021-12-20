package dao;

import pojo.EchartsBean;

import java.util.List;

public interface AirlineDao {
    public List<EchartsBean> queryAllAirline();
    public int getTotalRecords();
    public List<EchartsBean> queryAirlineByPage(int currentPage,int pageSize);
}
