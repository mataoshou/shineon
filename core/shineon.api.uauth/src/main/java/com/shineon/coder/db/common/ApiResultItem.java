package com.shineon.coder.db.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shineon.coder.service.convert.CommonItem;

import java.util.List;

public class ApiResultItem {

    private Integer code;

    private String msg;

    private JSONArray data = new JSONArray();

    public ApiResultItem(CommonItem item,Object data) throws Exception {

        this.msg = item.getErrorReason();
        this.code = item.getErrorStatus();

        if(data instanceof  List)
        {
            throw new Exception("List转换使用 ApiResultItem(CommonItem item, List data,boolean isConvert) 方法");
        }

        this.data.add(JSON.toJSON(data));

    }

    public ApiResultItem(CommonItem item, List data,boolean isConvert)
    {

        this.msg = item.getErrorReason();
        this.code = item.getErrorStatus();

        this.data.addAll(data);

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

    public JSONArray getData() {
        return data;
    }

    public void setData(JSONArray data) {
        this.data = data;
    }
}
