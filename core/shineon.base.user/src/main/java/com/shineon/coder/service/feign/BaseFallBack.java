package com.shineon.coder.service.feign;

import com.shineon.coder.kernel.constant.convert.CommonItemConstant;
import com.shineon.coder.service.convert.CommonItem;

public interface BaseFallBack {

    default CommonItem fail(String serverName)
    {
        CommonItem item = new CommonItem();
        item.setErrorStatus(CommonItemConstant.STATUS_FAIL);

        item.setErrorReason(String.format("[%s]服务访问失败！！",serverName ));

        return item;
    }
}
