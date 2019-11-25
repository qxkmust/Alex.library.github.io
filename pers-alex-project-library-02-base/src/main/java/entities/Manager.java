package entities;

/**
 * @ClassName Manager
 * @Description
 * @Date 2019/11/1 21:13
 * @Author Alex
 * @Version 1.0
 **/
public class Manager extends User{
    private static final Integer iId = 2; //2-老师
    private String sManagerId;
    private String sPwd;
    private String sManagerName;
    private Integer iManagerAge;
    private String sManagerPhone;

    public Manager(String sManagerId, String sPwd, String sManagerName, Integer iManagerAge, String sManagerPhone) {
        super(sManagerId, sPwd, iId);
        this.sManagerId = sManagerId;
        this.sPwd = sPwd;
        this.sManagerName = sManagerName;
        this.iManagerAge = iManagerAge;
        this.sManagerPhone = sManagerPhone;
    }

    @Override
    public String getsPwd() {
        return sPwd;
    }

    @Override
    public void setsPwd(String sPwd) {
        this.sPwd = sPwd;
    }

    public String getsManagerId() {
        return sManagerId;
    }

    public void setsManagerId(String sManagerId) {
        this.sManagerId = sManagerId;
    }

    public String getsManagerName() {
        return sManagerName;
    }

    public void setsManagerName(String sManagerName) {
        this.sManagerName = sManagerName;
    }

    public Integer getiManagerAge() {
        return iManagerAge;
    }

    public void setiManagerAge(Integer iManagerAge) {
        this.iManagerAge = iManagerAge;
    }

    public String getsManagerPhone() {
        return sManagerPhone;
    }

    public void setsManagerPhone(String sManagerPhone) {
        this.sManagerPhone = sManagerPhone;
    }
}
