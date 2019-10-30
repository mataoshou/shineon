package com.shineon.coder.service.dto;

import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.convert.CommonItemUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DTO是数据逻辑层
 * 所有数据通过本层进行逻辑处理
 */
@Service
public class BaseDTO implements CommonItemUtils {


    @Override
    public CommonItem toCommon(Object pojo) {
        return null;
    }

    @Override
    public CommonItem toCommon(List pojos) {
        return null;
    }

    @Override
    public Object toPojo(CommonItem item) {
        return null;
    }

    @Override
    public List toPojoList(CommonItem item) {
        return null;
    }
}
