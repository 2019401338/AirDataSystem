package dao;

import pojo.EchartsBean;

import java.util.List;

public interface AircraftDao {
   public List<EchartsBean> queryAllAircraft();
   public int getTotalRecords();
   public List<EchartsBean> queryAircraftByPage(int currentPage,int pageSize);
}
