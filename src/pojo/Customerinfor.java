package pojo;

public class Customerinfor {
    private int id;
    private String firstDate;
    private String sex;
    private String ffp_tier;
    private String workCity;
    private int age;
    private String flightCount;
    private String segKmSum;
    private String avgInterval;
    private String avgDiscount;
    private String pointsSum;
    private String image;

    public Customerinfor() {
    }

    public Customerinfor(int id, String firstDate, String sex, String ffp_tier, String workCity, int age, String flightCount, String segKmSum, String avgInterval, String avgDiscount, String pointsSum, String image) {
        this.id = id;
        this.firstDate = firstDate;
        this.sex = sex;
        this.ffp_tier = ffp_tier;
        this.workCity = workCity;
        this.age = age;
        this.flightCount = flightCount;
        this.segKmSum = segKmSum;
        this.avgInterval = avgInterval;
        this.avgDiscount = avgDiscount;
        this.pointsSum = pointsSum;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFfp_tier() {
        return ffp_tier;
    }

    public void setFfp_tier(String ffp_tier) {
        this.ffp_tier = ffp_tier;
    }

    public String getWorkCity() {
        return workCity;
    }

    public void setWorkCity(String workCity) {
        this.workCity = workCity;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFlightCount() {
        return flightCount;
    }

    public void setFlightCount(String flightCount) {
        this.flightCount = flightCount;
    }

    public String getSegKmSum() {
        return segKmSum;
    }

    public void setSegKmSum(String segKmSum) {
        this.segKmSum = segKmSum;
    }

    public String getAvgInterval() {
        return avgInterval;
    }

    public void setAvgInterval(String avgInterval) {
        this.avgInterval = avgInterval;
    }

    public String getAvgDiscount() {
        return avgDiscount;
    }

    public void setAvgDiscount(String avgDiscount) {
        this.avgDiscount = avgDiscount;
    }

    public String getPointsSum() {
        return pointsSum;
    }

    public void setPointsSum(String pointsSum) {
        this.pointsSum = pointsSum;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Customerinfor{" +
                "id=" + id +
                ", firstDate='" + firstDate + '\'' +
                ", sex='" + sex + '\'' +
                ", ffp_tier='" + ffp_tier + '\'' +
                ", workCity='" + workCity + '\'' +
                ", age=" + age +
                ", flightCount='" + flightCount + '\'' +
                ", segKmSum='" + segKmSum + '\'' +
                ", avgInterval='" + avgInterval + '\'' +
                ", avgDiscount='" + avgDiscount + '\'' +
                ", pointsSum='" + pointsSum + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
