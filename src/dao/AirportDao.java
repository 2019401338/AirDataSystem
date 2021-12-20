package dao;

import pojo.Airport;


import java.util.List;

public interface AirportDao {

//    public Airport querryOneAirportByName(String airport_Cname);
    public int getTotalRecords();
    public List<Airport> queryAirportByPage(int currentPage, int pageSize);
}
