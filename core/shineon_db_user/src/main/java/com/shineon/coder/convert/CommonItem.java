package com.shineon.coder.convert;

import java.util.ArrayList;
import java.util.List;

public class CommonItem {

    List<CommonData> datas;

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


    public List<CommonData> getDatas() {
        return datas;
    }

    public void setDatas(List<CommonData> datas) {
        this.datas = datas;
    }

    public void setDatas(CommonData data) {
        if(datas ==null){
            datas = new ArrayList();
        }
        this.datas.add(data);
    }
}
