package com.shineon.coder.action.sys;


import com.shineon.coder.kernel.common.action.ActionFactory;
import com.shineon.coder.kernel.common.cache.CacheFactory;
import com.shineon.coder.kernel.common.convert.ConvertFactory;
import com.shineon.coder.kernel.common.feign.FeignFactory;
import com.shineon.coder.kernel.constant.sys.SysConstant;
import com.shineon.coder.service.convert.BasicCommonUtil;
import com.shineon.coder.service.convert.CommonItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SysOperController {

    @Autowired
    BasicCommonUtil commonUtil;


    @RequestMapping("sys/oper/api")
    public CommonItem api(@RequestBody SysItem item) throws Exception {

        if(item==null)throw new Exception("参数为空，请检查！！");
        if(item.getName()==null||item.getName().trim().length()==0)throw new Exception("名称为空，请检查！！");

        if(item.getMethods()!=null)
        {
            item.setOper(item.getOper().replace("，",","));
        }

        ActionFactory factory = new ActionFactory();
        factory.build(item.getName(),Class.forName(item.getCommonName()),Class.forName(item.getPojoName()),item.getMethods(), SysConstant.CURRENT_SYS_NAME);
        return commonUtil.success();
    }

    @RequestMapping("sys/oper/feign")
    public CommonItem feign(@RequestBody SysItem item) throws Exception {

        if(item==null)throw new Exception("参数为空，请检查！！");
        if(item.getName()==null||item.getName().trim().length()==0)throw new Exception("名称为空，请检查！！");

        if(item.getMethods()!=null)
        {
            item.setOper(item.getOper().replace("，",","));
        }

        FeignFactory factory = new FeignFactory();
        factory.build(item.getName(),Class.forName(item.getCommonName()),Class.forName(item.getPojoName()),item.getMethods(),item.getSysName());
        return commonUtil.success();
    }

    @RequestMapping("sys/oper/convert")
    public CommonItem convert() throws Exception {


        ConvertFactory factory = new ConvertFactory();
        factory.build();
        return commonUtil.success();
    }


    @RequestMapping("sys/oper/cache")
    public CommonItem cache(@RequestBody SysItem item) throws Exception {


        if(item==null)throw new Exception("参数为空，请检查！！");
        if(item.getName()==null||item.getName().trim().length()==0)throw new Exception("名称为空，请检查！！");

        if(item.getOper()!=null)
        {
            item.setOper(item.getOper().replace("，",","));
        }

        CacheFactory factory = new CacheFactory();
        Class dotClass =Class.forName(item.getCommonName());
        Class pojoClass = Class.forName(item.getPojoName());
        factory.build(item.getName(),dotClass,pojoClass,item.getMethods(),item.getSysName());
        return commonUtil.success();
    }

}
