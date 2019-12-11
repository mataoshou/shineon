package com.shineon.coder.db.pojo;

import com.alibaba.fastjson.JSONObject;
import com.shineon.coder.kernel.constant.cache.CacheConstant;
import com.shineon.coder.kernel.util.Md5Util;

import java.util.Date;

public class QueryItem {

    private String id ;

    private String title;

    private String content;

    private Short status1;

    private Short status2;

    private Short status3;

    private Date beginTime;

    private Date endTime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Short getStatus1() {
        return status1;
    }

    public void setStatus1(Short status1) {
        this.status1 = status1;
    }

    public Short getStatus2() {
        return status2;
    }

    public void setStatus2(Short status2) {
        this.status2 = status2;
    }

    public Short getStatus3() {
        return status3;
    }

    public void setStatus3(Short status3) {
        this.status3 = status3;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
        return  CacheConstant.CACHE_LIST_PRE + "." + Md5Util.digest(this.toJsonString());
    }


}
