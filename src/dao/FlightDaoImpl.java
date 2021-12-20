package dao;

import DBUtil.DBUtil;
import pojo.Flight;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightDaoImpl implements FlightDao {

    @Override
    public List<Flight> queryAllFlight() {
        String sql="select * from flight_volume";
        Connection conn= DBUtil.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        List<Flight> list=new ArrayList<>();
        try {
            pstmt= conn.prepareStatement(sql);
            rs= pstmt.executeQuery();

            while (rs.next()) {
                Date date= rs.getDate(1);
                int cancelnum = rs.getInt(2);
                int usenum = rs.getInt(3);
                int allnum = rs.getInt(4);
                double userate = rs.getDouble(5);
                Flight flight=new Flight(date,usenum,cancelnum,allnum,userate);
                list.add(flight);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt,rs);
        }
        return list;
    }
}
