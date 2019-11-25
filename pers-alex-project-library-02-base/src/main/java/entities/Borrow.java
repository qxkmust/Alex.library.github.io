package entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName Borrow
 * @Description
 * @Date 2019/11/1 21:09
 * @Author Alex
 * @Version 1.0
 **/
public class Borrow extends Book{
    private String sStuId;
    private String sBookId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//    接收前端传入的日期字符串，转化为日期格式
    private Date sBorrowDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sExpectReturnDate;

    public Borrow() {
    }

    public Borrow(String sStuId, String sBookId) {
        this.sStuId = sStuId;
        this.sBookId = sBookId;
    }

    public Borrow(String sBookName, Date sBorrowDate, Date sExpectReturnDate) {
        super(sBookName);
        this.sBorrowDate = sBorrowDate;
        this.sExpectReturnDate = sExpectReturnDate;
    }

    public Borrow(Date sBorrowDate, Date sExpectReturnDate) {
        this.sBorrowDate = sBorrowDate;
        this.sExpectReturnDate = sExpectReturnDate;
    }

    public Borrow(String sSortId, String sSortName, String sBookId, String sBookName, String sBookAuthor, String sBookPub, Integer iBookNum, String sBookSort, String sBookRecord, String sStuId, Date sBorrowDate, Date sExpectReturnDate) {
        super(sSortId, sSortName, sBookId, sBookName, sBookAuthor, sBookPub, iBookNum, sBookSort, sBookRecord);
        this.sStuId = sStuId;
        this.sBorrowDate = sBorrowDate;
        this.sExpectReturnDate = sExpectReturnDate;
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

    public Date getsBorrowDate() {
        return sBorrowDate;
    }

    public void setsBorrowDate(Date sBorrowDate) {
        this.sBorrowDate = sBorrowDate;
    }

    public Date getsExpectReturnDate() {
        return sExpectReturnDate;
    }

    public void setsExpectReturnDate(Date sExpectReturnDate) {
        this.sExpectReturnDate = sExpectReturnDate;
    }
}
