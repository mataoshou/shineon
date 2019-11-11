package com.shineon.coder.service.convert;

import com.shineon.coder.db.pojo.SimpleItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class SimpleCommonUtil  implements CommonItemUtils<SimpleItem> {

    private CommonData toCommonData(SimpleItem pojo) {
        CommonData data = new CommonData();
        data.setId(pojo.getKey());
        data.setTitle(pojo.getValue());
        return data;
    }


    private SimpleItem toPojoData( CommonData data) {
        SimpleItem pojo = new SimpleItem();
        pojo.setKey(data.getId());
        pojo.setValue(data.getTitle());
        return pojo;
    }


    public CommonItem toCommon(SimpleItem pojo) {
        return success(toCommonData(pojo));
    }


    public CommonItem toCommon(List<SimpleItem> pojos) {
        List<CommonData> result = new ArrayList();
        for(SimpleItem item : pojos){
            result.add(toCommonData(item));
        }
        return success(result);
    }


    public SimpleItem toPojo( CommonItem item) {
        List<CommonData> datas = item.getDatas();
        if(datas ==null||datas.size()==0){log.debug("CommonItem 中data数据为空!!"); return null;}
        if(datas.size()>1){log.debug("CommonItem 中data数据不止一条数据!!"); }
        return toPojoData(datas.get(0));
    }


    public List<SimpleItem> toPojoList(  CommonItem item) {
        List<SimpleItem> result = new ArrayList();
        List<CommonData> datas = item.getDatas();
        for(CommonData data : datas){
            result.add(toPojoData(data));
        }
        return result;
    }
}
