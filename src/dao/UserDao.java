package dao;

import pojo.User;

import java.util.List;

public interface UserDao {
    public User queryOneUser(User user);
    public int insertUser(User user);

    public User queryOneUserById(String stanum);
    public int getTotalRecords(String szCondtion1);
    public List<User> queryUserByPage(int currentPage, int pageSize, String szCondtion);
    public int deleteUserByStanum(String stanum);
    public int updateUser(User user);

}
