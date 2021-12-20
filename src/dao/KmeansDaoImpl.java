package dao;

import DBUtil.DBUtil;
import pojo.Kmeans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KmeansDaoImpl implements KmeansDao {

    @Override
    public List<Kmeans> queryAllKmeans() {
        String sql="select * from kmeans_cluster";
        Connection conn=DBUtil.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        List<Kmeans> list =new ArrayList<>();
        try {
            pstmt= conn.prepareStatement(sql);
            rs= pstmt.executeQuery();

            while (rs.next()) {
                String category= rs.getString(1);
                String l = rs.getString(2);
                String r = rs.getString(3);
                String m = rs.getString(4);
                String f = rs.getString(5);
                String c = rs.getString(6);
                int number = rs.getInt(7);
                String level = rs.getString(8);
                Kmeans kmeans=new Kmeans(category,l,r,m,f,c,number,level);
                list.add(kmeans);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt,rs);
        }
        return list;
    }
}
