package com.shineon.coder.db.pojo;

public class MqMessage {
    private String id;

    //消息状态  0  已发送未消费  1消费未结束  100成功消费  -1 消费失败
    private short mstatus;

    //来源
    private String sourceSys ;

    //目的地
    private String dstSys;

    //消息主体
    private String message;

    private String mstype;

    //重试次数
    private int retry;

    private long lastModifyTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public short getMstatus() {
        return mstatus;
    }

    public void setMstatus(short mstatus) {
        this.mstatus = mstatus;
    }

    public String getSourceSys() {
        return sourceSys;
    }

    public void setSourceSys(String sourceSys) {
        this.sourceSys = sourceSys;
    }

    public String getDstSys() {
        return dstSys;
    }

    public void setDstSys(String dstSys) {
        this.dstSys = dstSys;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRetry() {
        return retry;
    }

    public void setRetry(int retry) {
        this.retry = retry;
    }

    public long getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(long lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public void changeStatus(short status)
    {
        this.mstatus = status;
        this.lastModifyTime = System.currentTimeMillis();
    }

    public void retrySend()
    {
        this.retry++;
        this.mstatus = 0;
        this.lastModifyTime = System.currentTimeMillis();
    }

    public String getMstype() {
        return mstype;
    }

    public void setMstype(String mstype) {
        this.mstype = mstype;
    }
}
