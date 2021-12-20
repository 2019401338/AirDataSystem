package service;

import dao.CustomerDaoImpl;
import dao.CustomerDao;
import pojo.Customerinfor;
import pojo.PageBean;
import service.imp.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao=new CustomerDaoImpl();
    @Override
    public PageBean<Customerinfor> queryCustomerByPage(int currentPage, int pageSize) {
        List<Customerinfor> customerinfors=customerDao.queryCustomerByPage(currentPage,pageSize);
        int total = customerDao.getTotalRecords();
        PageBean<Customerinfor> pageBean=new PageBean<>();
        pageBean.setPageSize(pageSize);
        pageBean.setTotalRecords(total);
        pageBean.setCurrentPageNum(currentPage);
        pageBean.setList(customerinfors);
        return pageBean;
    }
}
