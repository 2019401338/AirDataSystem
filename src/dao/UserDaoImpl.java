package dao;

import pojo.User;
import DBUtil.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User queryOneUser(User user) {
        String sql="select * from user where username=? and password=?";

        User u=null;
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        try {
            //2.获取连接
            conn= DBUtil.getConnection();
            //3.创建PreparedStatement
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            //4.执行操作    拉货
            rs = pstmt.executeQuery();
            //5.处理结果集  查询会有结果集 增删改 没有    处理货物
            if (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String pass = rs.getString(3);
                String pisition = rs.getString(4);

                u = new User(id, name, pass,pisition);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        //6. 关闭资源    路 砸了   货物 毁了 车 砸了
//        DBUtil.close(conn,pstmt, rs);
        return u;
    }

    @Override
    public int insertUser(User user) {
        String sql="INSERT INTO user (username, password,) VALUES ( ?, ?)";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt=null;
        int row=0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            row = pstmt.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt);
        }
        return row;
    }

    @Override
    public User queryOneUserById(String stanum) {
        String sql="select * from user where username=?";

        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        User user=null;
        try {
            pstmt= conn.prepareStatement(sql);
            pstmt.setString(1,stanum);
            rs= pstmt.executeQuery();

            if (rs.next()) {
                Integer id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String position = rs.getString(4);
                user = new User(id,username,password,position);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt,rs);
        }
        return user;
    }

    @Override
    public int getTotalRecords(String szCondtion1) {
        String sql="select count(*) from user"+szCondtion1;

        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        int count=0;
        try {
            pstmt= conn.prepareStatement(sql);
            rs= pstmt.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt,rs);
        }
        return count;
    }

    @Override
    public List<User> queryUserByPage(int currentPage, int pageSize, String szCondtion) {
        String sql="select * from user "+szCondtion+" limit ?,?";
        Connection conn = DBUtil.getConnection();
        List<User> list = new ArrayList<User>();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            pstmt= conn.prepareStatement(sql);
            //注意第一个参数值的写法
            pstmt.setInt(1,(currentPage-1)*pageSize);
            pstmt.setInt(2,pageSize);
            rs= pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String stanum = rs.getString(2);
                String password=rs.getString(3);
                String position=rs.getString(4);
               User user=new User(id,stanum,password,position);
                list.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt,rs);
        }
       return list;
    }


    @Override
    public int deleteUserByStanum(String stanum) {
        String sql="delete from user where username=?";

        Connection conn = DBUtil.getConnection();

        PreparedStatement pstmt=null;
        int row=0;
        try {
            pstmt= conn.prepareStatement(sql);
            pstmt.setString(1,stanum);
            row= pstmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt);
        }
        return row;
    }

    @Override
    public int updateUser(User user) {
        String sql="UPDATE user SET  id=?, username=?, password=?,position=? WHERE username=?";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt=null;
        int row=0;
        try {
            pstmt= conn.prepareStatement(sql);
            pstmt.setInt(1,user.getId());
            pstmt.setString(2,user.getUsername());
            pstmt.setString(3,user.getPassword());
            pstmt.setString(4,user.getPosition());
            pstmt.setString(5,user.getUsername());
            row= pstmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt);
        }
        return row;
    }

}
