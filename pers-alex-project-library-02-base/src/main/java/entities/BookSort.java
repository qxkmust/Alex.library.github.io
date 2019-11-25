package entities;

/**
 * @ClassName BookSort
 * @Description
 * @Date 2019/11/1 21:08
 * @Author Alex
 * @Version 1.0
 **/
public class BookSort{
    private String sSortId;
    private String sSortName;

    public BookSort() {
    }

    public BookSort(String sSortName) {
        this.sSortName = sSortName;
    }

    public BookSort(String sSortId, String sSortName) {
        this.sSortId = sSortId;
        this.sSortName = sSortName;
    }

    public String getsSortId() {
        return sSortId;
    }

    public void setsSortId(String sSortId) {
        this.sSortId = sSortId;
    }

    public String getsSortName() {
        return sSortName;
    }

    public void setsSortName(String sSortName) {
        this.sSortName = sSortName;
    }
}
