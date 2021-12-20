package dao;

import DBUtil.DBUtil;
import pojo.Customerinfor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public int getTotalRecords() {
        String sql="select count(*) from customer_infor";
        Connection conn= DBUtil.getConnection();
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
    public List<Customerinfor> queryCustomerByPage(int currentPage, int pageSize) {
        String sql="select * from customer_infor limit ?,?";
        Connection conn=DBUtil.getConnection();
        List<Customerinfor> list=new ArrayList<>();
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
                String firstDate = rs.getString(2);
                String sex = rs.getString(3);
                String ffp_tier = rs.getString(4);
                String workCity = rs.getString(5);
                int age = rs.getInt(6);
                String flightCount=rs.getString(7);
                String segKmSum=rs.getString(8);
                String avgInterval=rs.getString(9);
                String avgDiscount=rs.getString(10);
                String pointsSum=rs.getString(11);
                String image=rs.getString(12);
                Customerinfor customerinfor=new Customerinfor(id,firstDate,sex,ffp_tier,workCity,age,flightCount,segKmSum,avgInterval,avgDiscount,pointsSum,image);
                list.add(customerinfor);
//                System.out.println(customerinfor);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt,rs);
        }
        return list;
    }


}
