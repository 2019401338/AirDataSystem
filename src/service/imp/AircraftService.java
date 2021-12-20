package service.imp;

import pojo.EchartsBean;
import pojo.PageBean;

import java.util.List;

public interface AircraftService {
    public List<EchartsBean> querryAllAircraft();
    public PageBean<EchartsBean> queryAircraftByPage(int currentPage, int pageSize);
}
