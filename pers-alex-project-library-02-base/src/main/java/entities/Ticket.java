package entities;

import java.util.Date;

/**
 * @ClassName Ticket
 * @Description
 * @Date 2019/11/1 21:19
 * @Author Alex
 * @Version 1.0
 **/
public class Ticket extends Borrow{
    private String sStuId;
    private String sBookId;
    private Integer iOverDay;
    private Float fTicketFee;
    private Integer iPayoff;

    public Ticket() {
    }

    public Ticket(String sBookName, Date sBorrowDate, Date sExpectReturnDate, String sStuId, String sBookId, Integer iOverDay, Float fTicketFee, Integer iPayoff) {
        super(sBookName, sBorrowDate, sExpectReturnDate);
        this.sStuId = sStuId;
        this.sBookId = sBookId;
        this.iOverDay = iOverDay;
        this.fTicketFee = fTicketFee;
        this.iPayoff = iPayoff;
    }

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

    public Integer getiOverDay() {
        return iOverDay;
    }

    public void setiOverDay(Integer iOverDay) {
        this.iOverDay = iOverDay;
    }

    public Float getfTicketFee() {
        return fTicketFee;
    }

    public void setfTicketFee(Float fTicketFee) {
        this.fTicketFee = fTicketFee;
    }

    public Integer getiPayoff() {
        return iPayoff;
    }

    public void setiPayoff(Integer iPayoff) {
        this.iPayoff = iPayoff;
    }
}
