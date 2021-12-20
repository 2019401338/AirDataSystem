package pojo;


import java.sql.Date;

public class Flight {
    private Date date;
    private int cancelNum;
    private int useNum;
    private int allNum;
    private double useRate;

    public Flight() {
    }

    public Flight(Date date, int cancelNum, int useNum, int allNum, double useRate) {
        this.date = date;
        this.cancelNum = cancelNum;
        this.useNum = useNum;
        this.allNum = allNum;
        this.useRate = useRate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCancelNum() {
        return cancelNum;
    }

    public void setCancelNum(int cancelNum) {
        this.cancelNum = cancelNum;
    }

    public int getUseNum() {
        return useNum;
    }

    public void setUseNum(int useNum) {
        this.useNum = useNum;
    }

    public int getAllNum() {
        return allNum;
    }

    public void setAllNum(int allNum) {
        this.allNum = allNum;
    }

    public double getUseRate() {
        return useRate;
    }

    public void setUseRate(double useRate) {
        this.useRate = useRate;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "date=" + date +
                ", cancelNum=" + cancelNum +
                ", useNum=" + useNum +
                ", allNum=" + allNum +
                ", useRate=" + useRate +
                '}';
    }
}
