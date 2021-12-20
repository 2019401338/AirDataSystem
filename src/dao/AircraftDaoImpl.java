package dao;

import DBUtil.DBUtil;
import pojo.EchartsBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AircraftDaoImpl implements AircraftDao {
    @Override
    public List<EchartsBean> queryAllAircraft() {
        String sql="select * from aircraft_type";
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
//                Aircraft aircraft=new Aircraft(type,number);
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
        String sql="select count(*) from aircraft_type";
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
    public List<EchartsBean> queryAircraftByPage(int currentPage, int pageSize) {
        String sql="select * from aircraft_type limit ?,?";
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
                String aircraft=rs.getString(1);
                int number=rs.getInt(2);
                EchartsBean echartsBean=new EchartsBean(aircraft,number);
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
