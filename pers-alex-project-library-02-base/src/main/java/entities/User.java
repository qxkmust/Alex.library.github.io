package entities;

/**
 * @ClassName User
 * @Description
 * @Date 2019/11/3 13:29
 * @Author Alex
 * @Version 1.0
 **/
public class User {
    private String sUsername;//用户名
    private String sPwd;//密码
    private Boolean iRemember;//记住用户
    private Integer iIdentity;//标识身份,1-学生 2-老师

    public User() {
    }

    public User(String sUsername, String sPwd, Integer iIdentity) {
        this.sUsername = sUsername;
        this.sPwd = sPwd;
        this.iIdentity = iIdentity;
    }

    public String getsUsername() {
        return sUsername;
    }

    public void setsUsername(String sUsername) {
        this.sUsername = sUsername;
    }

    public String getsPwd() {
        return sPwd;
    }

    public void setsPwd(String sPwd) {
        this.sPwd = sPwd;
    }

    public Boolean getiRemember() {
        return iRemember;
    }

    public void setiRemember(Boolean iRemember) {
        this.iRemember = iRemember;
    }

    public Integer getiIdentity() {
        return iIdentity;
    }

    public void setiIdentity(Integer iIdentity) {
        this.iIdentity = iIdentity;
    }
}
