package pojo;

public class Airport {
    private String airport_Cname;
    private String airport_Ename;
    private String airport_city;
    private String airport_Ecity;
    private String city_three_code;
    private String IATA_code;
    private String ICAO_code;
    private String country;

    public Airport() {
    }

    public Airport(String airport_Cname, String airport_Ename, String airport_city, String airport_Ecity, String city_three_code, String IATA_code, String ICAO_code, String country) {
        this.airport_Cname = airport_Cname;
        this.airport_Ename = airport_Ename;
        this.airport_city = airport_city;
        this.airport_Ecity = airport_Ecity;
        this.city_three_code = city_three_code;
        this.IATA_code = IATA_code;
        this.ICAO_code = ICAO_code;
        this.country = country;
    }

    public String getAirport_Cname() {
        return airport_Cname;
    }

    public void setAirport_Cname(String airport_Cname) {
        this.airport_Cname = airport_Cname;
    }

    public String getAirport_Ename() {
        return airport_Ename;
    }

    public void setAirport_Ename(String airport_Ename) {
        this.airport_Ename = airport_Ename;
    }

    public String getAirport_city() {
        return airport_city;
    }

    public void setAirport_city(String airport_city) {
        this.airport_city = airport_city;
    }

    public String getAirport_Ecity() {
        return airport_Ecity;
    }

    public void setAirport_Ecity(String airport_Ecity) {
        this.airport_Ecity = airport_Ecity;
    }

    public String getCity_three_code() {
        return city_three_code;
    }

    public void setCity_three_code(String city_three_code) {
        this.city_three_code = city_three_code;
    }

    public String getIATA_code() {
        return IATA_code;
    }

    public void setIATA_code(String IATA_code) {
        this.IATA_code = IATA_code;
    }

    public String getICAO_code() {
        return ICAO_code;
    }

    public void setICAO_code(String ICAO_code) {
        this.ICAO_code = ICAO_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "airport_Cname='" + airport_Cname + '\'' +
                ", airport_Ename='" + airport_Ename + '\'' +
                ", airport_city='" + airport_city + '\'' +
                ", airport_Ecity='" + airport_Ecity + '\'' +
                ", city_three_code='" + city_three_code + '\'' +
                ", IATA_code='" + IATA_code + '\'' +
                ", ICAO_code='" + ICAO_code + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
