package dao;

import DBUtil.DBUtil;
import pojo.EchartsBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirlineDaoImpl implements AirlineDao {
    @Override
    public List<EchartsBean> queryAllAirline() {
        String sql="select * from airline_ranking";
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        List<EchartsBean> list=new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        try{
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                String type = rs.getString(1);
                int number = rs.getInt(2);
                EchartsBean echartsBean=new EchartsBean(type,number);
//                System.out.println(echartsBean);
                list.add(echartsBean);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            //6. 关闭资源   货 车 路全都毁了
            DBUtil.close(conn,pstmt,rs);
        }
        return list;
    }

    @Override
    public int getTotalRecords() {
        String sql="select count(*) from airline_ranking";
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
    public List<EchartsBean> queryAirlineByPage(int currentPage, int pageSize) {
        String sql="select * from airline_ranking limit ?,?";
        Connection conn = DBUtil.getConnection();
        List<EchartsBean> list = new ArrayList<>();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            pstmt= conn.prepareStatement(sql);
            //注意第一个参数值的写法
            pstmt.setInt(1,(currentPage-1)*pageSize);
            pstmt.setInt(2,pageSize);
            rs= pstmt.executeQuery();

            while (rs.next()) {
                String company=rs.getString(1);
                int number=rs.getInt(2);
                EchartsBean echartsBean=new EchartsBean(company,number);
                list.add(echartsBean);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt,rs);
        }
        return list;
    }
}
