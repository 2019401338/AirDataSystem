package dao;

import pojo.Customerinfor;

import java.util.List;

public interface CustomerDao {
    public int getTotalRecords();
    public List<Customerinfor> queryCustomerByPage(int currentPage, int pageSize);
}
