package entities;


/**
 * @ClassName Log
 * @Description
 * @Date 2019/11/18 22:57
 * @Author Alex
 * @Version 1.0
 **/
public class Log {
    private Long iLogId;
    private String sUsername;
    private String sIp;
    private String sLogDetail;
    private String sLogTime;
    private Long iTimespan;

    public Log() {
    }

    public Log(String sUsername, String sIp, String sLogDetail, String sLogTime, Long iTimespan) {
        this.sUsername = sUsername;
        this.sIp = sIp;
        this.sLogDetail = sLogDetail;
        this.sLogTime = sLogTime;
        this.iTimespan = iTimespan;
    }

    public Long getiLogId() {
        return iLogId;
    }

    public void setiLogId(Long iLogId) {
        this.iLogId = iLogId;
    }

    public String getsUsername() {
        return sUsername;
    }

    public void setsUsername(String sUsername) {
        this.sUsername = sUsername;
    }

    public String getsIp() {
        return sIp;
    }

    public void setsIp(String sIp) {
        this.sIp = sIp;
    }

    public String getsLogDetail() {
        return sLogDetail;
    }

    public void setsLogDetail(String sLogDetail) {
        this.sLogDetail = sLogDetail;
    }

    public String getsLogTime() {
        return sLogTime;
    }

    public void setsLogTime(String sLogTime) {
        this.sLogTime = sLogTime;
    }

    public Long getiTimespan() {
        return iTimespan;
    }

    public void setiTimespan(Long iTimespan) {
        this.iTimespan = iTimespan;
    }
}
