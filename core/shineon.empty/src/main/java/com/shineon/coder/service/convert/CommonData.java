package com.shineon.coder.service.convert;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@Scope("prototype")
public class CommonData {

    private String id;

    private String parent;

    private String group;

    private Short status1;

    private Short status2;

    private Short status3;

    private Short status4;

    private Integer sortIndex;

    private String title ;

    private String ptitle;

    private String thumb;

    private String content;

    private Date createTime;

    private String creator;

    private  Date beginTime;

    private Date endTime;


    private  long begin;

    private long end;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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

    public long getBegin() {
        return begin;
    }

    public void setBegin(long begin) {
        this.begin = begin;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public Short getStatus4() {
        return status4;
    }

    public void setStatus4(Short status4) {
        this.status4 = status4;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }
}
