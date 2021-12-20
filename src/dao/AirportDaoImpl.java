package dao;

import pojo.Airport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DBUtil.DBUtil;

public class AirportDaoImpl implements AirportDao {
//    @Override
//    public Airport querryOneAirportByName(String airport_Cname) {
//        String sql="select * from airport_data where airport_Cname=?";
//        Connection conn = DBUtil.getConnection();
//        PreparedStatement pstmt=null;
//        ResultSet rs=null;
//        Airport airport=null;
//        try {
//            pstmt= conn.prepareStatement(sql);
//            pstmt.setString(1,airport_Cname);
//            rs= pstmt.executeQuery();
//
//            if (rs.next()) {
//                String  airport_Cname1= rs.getString(1);
//                String airport_Ename = rs.getString(2);
//                String airport_city = rs.getString(3);
//                String airport_Ecity = rs.getString(4);
//                String city_three_code = rs.getString(5);
//                String IATA_code = rs.getString(6);
//                String ICAO_code=rs.getString(7);
//                String country=rs.getString(8);
//                airport = new Airport(airport_Cname1, airport_Ename, airport_city, airport_Ecity, city_three_code, IATA_code,ICAO_code,country);
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }finally {
//            DBUtil.close(conn,pstmt,rs);
//        }
//        return airport;
//    }

    @Override
    public int getTotalRecords() {
        String sql="select count(*) from airport_data";
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
    public List<Airport> queryAirportByPage(int currentPage, int pageSize) {
        String sql="select * from airport_data limit ?,?";
        Connection conn = DBUtil.getConnection();
        List<Airport> list = new ArrayList<>();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            pstmt= conn.prepareStatement(sql);
            //注意第一个参数值的写法
            pstmt.setInt(1,(currentPage-1)*pageSize);
            pstmt.setInt(2,pageSize);
            rs= pstmt.executeQuery();

            while (rs.next()) {
                String  airport_Cname1= rs.getString(1);
                String airport_Ename = rs.getString(2);
                String airport_city = rs.getString(3);
                String airport_Ecity = rs.getString(4);
                String city_three_code = rs.getString(5);
                String IATA_code = rs.getString(6);
                String ICAO_code=rs.getString(7);
                String country=rs.getString(8);
                Airport airport = new Airport(airport_Cname1, airport_Ename, airport_city, airport_Ecity, city_three_code, IATA_code,ICAO_code,country);
                list.add(airport);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt,rs);
        }
        return list;
    }
}
