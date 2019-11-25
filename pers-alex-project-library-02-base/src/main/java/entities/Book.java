package entities;

import java.util.Date;

/**
 * @ClassName Book
 * @Description
 * @Date 2019/11/1 21:01
 * @Author Alex
 * @Version 1.0
 **/
public class Book extends BookSort{
    private String sBookId;
    private String sBookName;
    private String sBookAuthor;
    private String sBookPub;
    private Integer iBookNum;
    private String sBookSort;
    private String sBookRecord;

    public Book() {
    }

    public Book(String sBookName) {
        this.sBookName = sBookName;
    }

    public Book(String sSortId, String sSortName, String sBookId, String sBookName, String sBookAuthor, String sBookPub, Integer iBookNum, String sBookSort, String sBookRecord) {
        super(sSortId, sSortName);
        this.sBookId = sBookId;
        this.sBookName = sBookName;
        this.sBookAuthor = sBookAuthor;
        this.sBookPub = sBookPub;
        this.iBookNum = iBookNum;
        this.sBookSort = sBookSort;
        this.sBookRecord = sBookRecord;
    }

    public Book(String sSortName, String sBookId, String sBookName, String sBookAuthor, String sBookPub, Integer iBookNum, String sBookSort, String sBookRecord) {
        super(sSortName);
        this.sBookId = sBookId;
        this.sBookName = sBookName;
        this.sBookAuthor = sBookAuthor;
        this.sBookPub = sBookPub;
        this.iBookNum = iBookNum;
        this.sBookSort = sBookSort;
        this.sBookRecord = sBookRecord;
    }

    public String getsBookId() {
        return sBookId;
    }

    public void setsBookId(String sBookId) {
        this.sBookId = sBookId;
    }

    public String getsBookName() {
        return sBookName;
    }

    public void setsBookName(String sBookName) {
        this.sBookName = sBookName;
    }

    public String getsBookAuthor() {
        return sBookAuthor;
    }

    public void setsBookAuthor(String sBookAuthor) {
        this.sBookAuthor = sBookAuthor;
    }

    public String getsBookPub() {
        return sBookPub;
    }

    public void setsBookPub(String sBookPub) {
        this.sBookPub = sBookPub;
    }

    public Integer getiBookNum() {
        return iBookNum;
    }

    public void setiBookNum(Integer iBookNum) {
        this.iBookNum = iBookNum;
    }

    public String getsBookSort() {
        return sBookSort;
    }

    public void setsBookSort(String sBookSort) {
        this.sBookSort = sBookSort;
    }

    public String getsBookRecord() {
        return sBookRecord;
    }

    public void setsBookRecord(String sBookRecord) {
        this.sBookRecord = sBookRecord;
    }
}
