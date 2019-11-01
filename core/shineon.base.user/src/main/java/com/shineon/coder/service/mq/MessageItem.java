package com.shineon.coder.service.mq;

import com.alibaba.fastjson.JSONObject;
import com.shineon.coder.service.convert.CommonItem;

public class MessageItem {

    private String id;

    private String sourceName;

    private String dstName;

    private Integer operType;

    private CommonItem data;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getDstName() {
        return dstName;
    }

    public void setDstName(String dstName) {
        this.dstName = dstName;
    }

    public CommonItem getData() {
        return data;
    }

    public void setData(CommonItem data) {
        this.data = data;
    }


    public Integer getOperType() {
        return operType;
    }

    public void setOperType(Integer operType) {
        this.operType = operType;
    }

    public String toJsonString ()
    {
        return JSONObject.toJSONString(this);
    }

    public JSONObject toJson()
    {
        return (JSONObject) JSONObject.toJSON(this);
    }
}
