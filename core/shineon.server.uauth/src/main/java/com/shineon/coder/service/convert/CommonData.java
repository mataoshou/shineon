package com.shineon.coder.service.convert;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Component
@Scope("prototype")
public class CommonData {

    private Integer id;

    private Integer parent;

    private Integer group;

    private Short initStatus;

    private Short currentStatus1;

    private Short currentStatus2;

    private String title ;

    private String ptitle;

    private String name;

    private String thumb;

    private String content;

    private Date createTime;

    private Date modifiedTime;

    private  Date beginTime;

    private Date endTime;

    private long interval;


    public Short getInitStatus() {
        return initStatus;
    }

    public void setInitStatus(Short initStatus) {
        this.initStatus = initStatus;
    }

    public Short getCurrentStatus1() {
        return currentStatus1;
    }

    public void setCurrentStatus1(Short currentStatus1) {
        this.currentStatus1 = currentStatus1;
    }

    public Short getCurrentStatus2() {
        return currentStatus2;
    }

    public void setCurrentStatus2(Short currentStatus2) {
        this.currentStatus2 = currentStatus2;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    private List<CommonData> attachItems;

    public List<CommonData> getAttachItems() {
        return attachItems;
    }

    public void setAttachItems(List<CommonData> attachItems) {
        this.attachItems = attachItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public long getInterval() {
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }
}
