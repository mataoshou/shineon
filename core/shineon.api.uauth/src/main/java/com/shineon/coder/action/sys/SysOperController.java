package com.shineon.coder.action.sys;


import com.shineon.coder.kernel.common.action.ActionBuild;
import com.shineon.coder.kernel.common.cache.CacheBuild;
import com.shineon.coder.kernel.common.convert.ConvertBuild;
import com.shineon.coder.kernel.common.feign.FeignBuild;
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
            item.setMethods(item.getMethods().replace("，",","));
        }

        ActionBuild build = new ActionBuild();
        build.build(item.getName(),Class.forName(item.getCommonName()),Class.forName(item.getPojoName()),item.getMethods().split(","));
        return commonUtil.success();
    }

    @RequestMapping("sys/oper/feign")
    public CommonItem feign(@RequestBody SysItem item) throws Exception {

        if(item==null)throw new Exception("参数为空，请检查！！");
        if(item.getName()==null||item.getName().trim().length()==0)throw new Exception("名称为空，请检查！！");

        if(item.getMethods()!=null)
        {
            item.setMethods(item.getMethods().replace("，",","));
        }

        FeignBuild build = new FeignBuild();
        build.build(item.getName(),item.getSysName(),item.getMethods().split(","));
        return commonUtil.success();
    }

    @RequestMapping("sys/oper/db")
    public CommonItem db()  {


//        GeneratorSql build = new GeneratorSql();
//        build.build();
        return commonUtil.success();
    }

    @RequestMapping("sys/oper/convert")
    public CommonItem convert() throws Exception {


        ConvertBuild build = new ConvertBuild();
        build.buildConvert();
        return commonUtil.success();
    }


    @RequestMapping("sys/oper/cache")
    public CommonItem cache(@RequestBody SysItem item) throws Exception {


        if(item==null)throw new Exception("参数为空，请检查！！");
        if(item.getName()==null||item.getName().trim().length()==0)throw new Exception("名称为空，请检查！！");

        if(item.getMethods()!=null)
        {
            item.setMethods(item.getMethods().replace("，",","));
        }

        CacheBuild build = new CacheBuild();
        Class dotClass =Class.forName(item.getCommonName());
        Class pojoClass = Class.forName(item.getPojoName());
        build.build(item.getName(),dotClass,pojoClass);
        return commonUtil.success();
    }

}
