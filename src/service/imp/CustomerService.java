package service.imp;

import pojo.Customerinfor;
import pojo.PageBean;

public interface CustomerService {
    public PageBean<Customerinfor> queryCustomerByPage(int currentPage, int pageSize);
}
