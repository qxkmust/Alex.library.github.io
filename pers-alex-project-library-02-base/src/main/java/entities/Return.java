package entities;

import java.util.Date;

/**
 * @ClassName Return
 * @Description
 * @Date 2019/11/1 21:14
 * @Author Alex
 * @Version 1.0
 **/
public class Return {
    private String sStuId;
    private String sBookId;
    private String sBorrowDate;
    private String sReturnDate;

    public String getsStuId() {
        return sStuId;
    }

    public void setsStuId(String sStuId) {
        this.sStuId = sStuId;
    }

    public String getsBookId() {
        return sBookId;
    }

    public void setsBookId(String sBookId) {
        this.sBookId = sBookId;
    }

    public String getsBorrowDate() {
        return sBorrowDate;
    }

    public void setsBorrowDate(String sBorrowDate) {
        this.sBorrowDate = sBorrowDate;
    }

    public String getsReturnDate() {
        return sReturnDate;
    }

    public void setsReturnDate(String sReturnDate) {
        this.sReturnDate = sReturnDate;
    }
}
