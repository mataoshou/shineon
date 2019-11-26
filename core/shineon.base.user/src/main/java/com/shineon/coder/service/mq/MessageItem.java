package com.shineon.coder.service.mq;

import com.alibaba.fastjson.JSONObject;
import com.shineon.coder.kernel.constant.message.MessageConstant;
import com.shineon.coder.kernel.util.GuidUtil;
import com.shineon.coder.kernel.util.Md5Util;
import com.shineon.coder.service.convert.CommonItem;

public class MessageItem {

    private String id;

    private String sourceName;

    private String dstName;

    private String operType;

    private String operObjectName;

    private String mstype = MessageConstant.MESSAGE_TYPE_SINGLE;

    private CommonItem data;

    public MessageItem()
    {
//        this.id =
    }


    public String getMstype() {
        return mstype;
    }

    public void setMstype(String mstype) {
        this.mstype = mstype;
    }

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

    public String getOperObjectName() {
        return operObjectName;
    }

    public void setOperObjectName(String operObjectName) {
        this.operObjectName = operObjectName;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
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


    public String toCode() throws Exception {
        return  Md5Util.digest(this.getData().toJsonString());
    }
}
