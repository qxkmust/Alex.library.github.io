package entities;

/**
 * @ClassName Student
 * @Description
 * @Date 2019/11/1 21:16
 * @Author Alex
 * @Version 1.0
 **/
public class Student extends User{
    private static final Integer iId = 1;
    private String sStuId;
    private String sPwd;
    private String sStuName;
    private String sStuSex;
    private Integer iStuAge;
    private String sStuMajor;
    private String sStuGrade;
    private Integer iStuIntegrity;
    private Integer iBooks;
    private Float fBills;

    public Student() {
    }

    public Student(String sStuId, String sStuName, String sStuMajor, String sStuGrade, Integer iStuIntegrity, Integer iBooks, Float fBills) {
        super();
        this.sStuId = sStuId;
        this.sStuName = sStuName;
        this.sStuMajor = sStuMajor;
        this.sStuGrade = sStuGrade;
        this.iStuIntegrity = iStuIntegrity;
        this.iBooks = iBooks;
        this.fBills = fBills;
    }

    public String getsStuId() {
        return sStuId;
    }

    public void setsStuId(String sStuId) {
        this.sStuId = sStuId;
    }

    @Override
    public String getsPwd() {
        return sPwd;
    }

    @Override
    public void setsPwd(String sPwd) {
        this.sPwd = sPwd;
    }

    public String getsStuName() {
        return sStuName;
    }

    public void setsStuName(String sStuName) {
        this.sStuName = sStuName;
    }

    public String getsStuSex() {
        return sStuSex;
    }

    public void setsStuSex(String sStuSex) {
        this.sStuSex = sStuSex;
    }

    public Integer getiStuAge() {
        return iStuAge;
    }

    public void setiStuAge(Integer iStuAge) {
        this.iStuAge = iStuAge;
    }

    public String getsStuMajor() {
        return sStuMajor;
    }

    public void setsStuMajor(String sStuMajor) {
        this.sStuMajor = sStuMajor;
    }

    public String getsStuGrade() {
        return sStuGrade;
    }

    public void setsStuGrade(String sStuGrade) {
        this.sStuGrade = sStuGrade;
    }

    public Integer getiStuIntegrity() {
        return iStuIntegrity;
    }

    public void setiStuIntegrity(Integer iStuIntegrity) {
        this.iStuIntegrity = iStuIntegrity;
    }

    public Integer getiBooks() {
        return iBooks;
    }

    public void setiBooks(Integer iBooks) {
        this.iBooks = iBooks;
    }

    public Float getfBills() {
        return fBills;
    }

    public void setfBills(Float fBills) {
        this.fBills = fBills;
    }
}
