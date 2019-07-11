package com.shineon.coder.common.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * 存储消息信息的pojo对象
 */
@Component
@Scope("prototype")
public class MessageItem
{

    //消息id
    private Integer id;
    //消息编码
    private  String code;
    //消息类型
    private Integer type;
    //操作
    private String oper;

    ///以发送次数
    private Integer count = 0;

    //来源
    private String src;
    //目的地
    private String dst;
    //重试次数
    private Integer retry = 3;
    //内容
    private String content;
    //是否广播
    private boolean publishAll;
    //开始时间
    private Long beginTime;

    //重发时间
    private Long retryTime;

    /**
     * 消息状态   0已发送  1 发送并成功接收   100 成功并返回    -1 发送失败   -2 返回失败
     */
    private int status;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public int getRetry() {
        return retry;
    }

    public void setRetry(int retry) {
        this.retry = retry;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getPublishAll() {
        return publishAll;
    }

    public void setPublishAll(boolean publishAll) {
        this.publishAll = publishAll;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public long getRetryTime() {
        return retryTime;
    }

    public void setRetryTime(long retryTime) {
        this.retryTime = retryTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }






    public MessageItem()
    {


    }

}
