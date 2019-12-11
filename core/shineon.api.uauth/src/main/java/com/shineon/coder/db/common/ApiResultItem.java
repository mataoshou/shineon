package com.shineon.coder.db.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shineon.coder.service.convert.CommonItem;

public class ApiResultItem {

    private Integer code;

    private String msg;

    private JSONObject data;

    public ApiResultItem(CommonItem item,Object data)
    {

        this.msg = item.getErrorReason();
        this.code = item.getErrorStatus();

        this.data = (JSONObject) JSON.toJSON(data);

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

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }
}
