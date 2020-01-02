package com.shineon.coder.action.sys;


import com.shineon.coder.kernel.common.action.ActionFactory;
import com.shineon.coder.kernel.common.bo.BOFactory;
import com.shineon.coder.kernel.common.cache.CacheFactory;
import com.shineon.coder.kernel.common.convert.ConvertFactory;
import com.shineon.coder.kernel.common.feign.FeignFactory;
import com.shineon.coder.kernel.common.generator.GeneratorFactory;
import com.shineon.coder.kernel.common.ibase.IFactory;
import com.shineon.coder.kernel.constant.action.ActionConstant;
import com.shineon.coder.kernel.constant.feign.FeignConstant;
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
        }else{
            item.setMethods(ActionConstant.ACTION_METHOD);
        }

        ActionFactory factory = new ActionFactory(item.getName(),Class.forName(item.getCommonName()),Class.forName(item.getPojoName()),item.getMethods(), SysConstant.CURRENT_SYS_NAME);
        oper(factory,item);
        return commonUtil.success();
    }



    @RequestMapping("sys/oper/feign")
    public CommonItem feign(@RequestBody SysItem item) throws Exception {

        if(item==null)throw new Exception("参数为空，请检查！！");
        if(item.getName()==null||item.getName().trim().length()==0)throw new Exception("名称为空，请检查！！");

        if(item.getMethods()!=null)
        {
            item.setOper(item.getOper().replace("，",","));
        }else{
            item.setMethods(FeignConstant.FEIGN_METHOD);
        }

        FeignFactory factory = new FeignFactory(item.getName(),Class.forName(item.getCommonName()),Class.forName(item.getPojoName()),item.getMethods()
                ,item.getSysName());
        oper(factory,item);
        return commonUtil.success();
    }

    @RequestMapping("sys/oper/db")
    public CommonItem db(@RequestBody SysItem item) throws Exception {


        GeneratorFactory factory = new GeneratorFactory();
        factory.build();
        return commonUtil.success();
    }

    @RequestMapping("sys/oper/convert")
    public CommonItem convert(@RequestBody SysItem item) throws Exception {


        ConvertFactory factory = new ConvertFactory();
        oper(factory,item);
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
        Class dotClass =Class.forName(item.getCommonName());
        Class pojoClass = Class.forName(item.getPojoName());
        CacheFactory factory = new CacheFactory(item.getName(),dotClass,pojoClass,item.getMethods(),item.getSysName());
        oper(factory,item);
        return commonUtil.success();
    }

    @RequestMapping("sys/oper/bo")
    public CommonItem bo(@RequestBody SysItem item) throws Exception {
        if(item==null)throw new Exception("参数为空，请检查！！");
        if(item.getName()==null||item.getName().trim().length()==0)throw new Exception("名称为空，请检查！！");

        if(item.getOper()!=null)
        {
            item.setOper(item.getOper().replace("，",","));
        }
        Class dotClass =Class.forName(item.getCommonName());
        Class pojoClass = Class.forName(item.getPojoName());
        BOFactory factory = new BOFactory(item.getName(),dotClass,pojoClass,item.getMethods(),item.getSysName());
        oper(factory,item);
        return commonUtil.success();
    }

    @RequestMapping("sys/oper/buildAll")
    public CommonItem buildAll(@RequestBody SysItem item) throws Exception {


        if(item==null)throw new Exception("参数为空，请检查！！");
        if(item.getName()==null||item.getName().trim().length()==0)throw new Exception("名称为空，请检查！！");

        if(item.getOper()!=null)
        {
            item.setOper(item.getOper().replace("，",","));
        }
        ActionFactory actionfactory = new ActionFactory(item.getName(),Class.forName(item.getCommonName()),Class.forName(item.getPojoName()),item.getMethods(), SysConstant.CURRENT_SYS_NAME);
        oper(actionfactory,item);


        FeignFactory feignfactory = new FeignFactory(item.getName(),Class.forName(item.getCommonName()),Class.forName(item.getPojoName()),item.getMethods()
                ,item.getSysName());
        oper(feignfactory,item);
        return commonUtil.success();
    }


    public void oper(IFactory factory,SysItem item) throws Exception {
        if(item.getCreateType()==0)
        {
            factory.build();
        }
        else if(item.getCreateType()==1)
        {
            factory.rebuild();
        }
        else if(item.getCreateType()==3)
        {
            factory.edit();
        }
        else if(item.getCreateType()==2)
        {
            factory.delete();
        }
    }

}
