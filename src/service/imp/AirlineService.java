package service.imp;

import pojo.EchartsBean;
import pojo.PageBean;

import java.util.List;

public interface AirlineService {
    public List<EchartsBean> querryAllAirlline();
    public PageBean<EchartsBean> queryAirlineByPage(int currentPage, int pageSize);
}
