package entities;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName RestSet
 * @Description
 * @Date 2019/11/21 11:38
 * @Author Alex
 * @Version 1.0
 **/
public class RestSet{
    private boolean status = false;
    private String viewName;

    public RestSet(){}
    public RestSet(boolean status){
        this.status = status;
    }
    public RestSet(boolean status,String viewName){
        this.status = status;
        this.viewName = viewName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }
}
