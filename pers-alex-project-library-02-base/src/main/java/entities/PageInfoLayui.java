package entities;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @ClassName PageInfoLayui
 * @Description 定义layui分页的数据格式类
 * @Date 2019/11/10 17:00
 * @Author Alex
 * @Version 1.0
 **/
public class PageInfoLayui<T> extends PageInfo {
    private Integer code = 0; //解析接口状态
    private String msg = ""; //解析提示文本
    private Integer count; //解析数据长度
    private List<T> data;//解析数据列表
    private Map<String,Object> extra;//预留字段，存储额外信息

    public PageInfoLayui(List list) {
        super(list);
        this.data = list;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    /*
    * 利用fastjson工具，序列化为标准的json格式
    * */
    public static String jsonStr(Object obj){
        return JSONObject.toJSONString(obj, SerializerFeature.WriteNonStringValueAsString);//标准的json格式，属性名和值均含双引号
    }
}
