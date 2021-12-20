package service.imp;

import pojo.PageBean;
import pojo.User;

public interface UserService {
    //登录
    public User login(User user);
    //注册
    public boolean register(User user);

    public User queryOneUserById(String stanum);
    public PageBean<User> queryUserByPage(int currentPage, int pageSize, String szCondtion);
    public boolean deleteUserByStanum(String stanum);
    public boolean updateUser(User user);

}
