package com.shineon.coder.convert;

import com.shineon.coder.constant.CommonItemConstant;

public class CommonItemUtils {

    ///////////////////////////////////////////////////////////////////////////////////////////
    ///  成功
    //////////////////////////////////////////////////////////////////////////////////////////
    public CommonItem successEmpty()
    {
        CommonItem item = new CommonItem();

        return success(item);
    }

    public CommonItem success(CommonItem item)
    {
        item.setErrorStatus(CommonItemConstant.STATUS_SUCCESS);
        item.setErrorReason(CommonItemConstant.REASON_SUCCESS);


        return  item;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    ///  失败
    //////////////////////////////////////////////////////////////////////////////////////////
    public CommonItem fail()
    {
        CommonItem item = new CommonItem();

        return fail(item);
    }

    public CommonItem fail(CommonItem item)
    {
        return fail(item, CommonItemConstant.STATUS_FAIL, CommonItemConstant.REASON_FAIL);
    }

    public CommonItem fail(CommonItem item , String reason)
    {
        return fail(item, CommonItemConstant.STATUS_FAIL,reason);
    }

    public CommonItem fail(CommonItem item, int errorStatus, String reason)
    {
        item.setErrorStatus(errorStatus);

        item.setErrorReason(reason);

        return item;
    }

}
