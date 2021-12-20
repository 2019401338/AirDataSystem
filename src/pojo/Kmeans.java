package pojo;

public class Kmeans {
    private String category;
    private String l;
    private String r;
    private String m;
    private String f;
    private String c;
    private int number;
    private String level;

    public Kmeans() {
    }

    public Kmeans(String category, String l, String r, String m, String f, String c, int number, String level) {
        this.category = category;
        this.l = l;
        this.r = r;
        this.m = m;
        this.f = f;
        this.c = c;
        this.number = number;
        this.level = level;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Kmeans{" +
                "category='" + category + '\'' +
                ", l='" + l + '\'' +
                ", r='" + r + '\'' +
                ", m='" + m + '\'' +
                ", f='" + f + '\'' +
                ", c='" + c + '\'' +
                ", number=" + number +
                ", level='" + level + '\'' +
                '}';
    }
}
