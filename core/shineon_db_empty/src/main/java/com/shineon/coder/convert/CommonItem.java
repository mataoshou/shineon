package com.shineon.coder.convert;

public class CommonItem {

    CommonData data;

    private Integer errorStatus;

    private String errorReason;

    public Integer getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(Integer errorStatus) {
        this.errorStatus = errorStatus;
    }

    public String getErrorReason() {
        return errorReason;
    }

    public void setErrorReason(String errorReason) {
        this.errorReason = errorReason;
    }

    public CommonData getData() {
        return data;
    }

    public void setData(CommonData data) {
        this.data = data;
    }
}
