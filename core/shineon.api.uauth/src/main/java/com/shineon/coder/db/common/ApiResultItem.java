package com.shineon.coder.db.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shineon.coder.service.convert.CommonItem;

import java.util.Collection;
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
            if(data!=null) {
                this.data.addAll((Collection<? extends Object>) data);
            }
        }
        else if(data!=null) {
            this.data.add(JSON.toJSON(data));
        }

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
