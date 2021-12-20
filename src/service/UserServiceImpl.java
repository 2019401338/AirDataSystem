package service;

import dao.UserDaoImpl;
import dao.UserDao;
import pojo.PageBean;
import pojo.User;
import service.imp.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    @Override
    public User login(User user) {
        return userDao.queryOneUser(user);
    }

    @Override
    public boolean register(User user) {
        int row = userDao.insertUser(user);
        if(row>0){
            return true;
        }
        return false;
    }


    @Override
    public User queryOneUserById(String stanum) {
        return userDao.queryOneUserById(stanum);
    }

    @Override
    public PageBean<User> queryUserByPage(int currentPage, int pageSize, String szCondtion) {
        List<User> users = userDao.queryUserByPage(currentPage, pageSize,szCondtion);
        int total = userDao.getTotalRecords(szCondtion);
        PageBean<User> pageBean=new PageBean<>();
        pageBean.setPageSize(pageSize);//设置页面大小
        pageBean.setTotalRecords(total);//设置总记录数
        pageBean.setCurrentPageNum(currentPage);//设置当前页
        pageBean.setList(users);//设置当前页数据
        return pageBean;
    }

    @Override
    public boolean deleteUserByStanum(String stanum) {
        int row = userDao.deleteUserByStanum(stanum);
        if(row>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        int row = userDao.updateUser(user);
        if(row>0){
            return true;
        }
        return false;
    }

}
