package com.shineon.coder.service.mq.oper;

import com.shineon.coder.kernel.constant.message.MessageConstant;
import com.shineon.coder.service.convert.CommonItemUtils;
import com.shineon.coder.service.mq.MessageItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import java.util.List;

public abstract class IBaseMessageOperation<POJO,DTO extends CommonItemUtils<POJO>>
        implements ApplicationListener<ApplicationReadyEvent> {

    protected abstract POJO edit(POJO pojo);

    protected abstract POJO delete(POJO pojo);

    protected  POJO reply(POJO pojo){return pojo;}

    protected  List<POJO> reply(List<POJO> pojos){return  pojos;}

    @Autowired
    protected DTO dto;

    private String pojoName = null;


    /**
     * 根据operType进行操作
     * @param item
     * @return
     */
    public final POJO oper(MessageItem item) throws Exception {
        POJO pojo = dto.toPojo(item.getData());
        switch (item.getOperType())
        {
            case MessageConstant.MESSAGE_OPER_INSERT :pojo =edit(pojo);break;
            case MessageConstant.MESSAGE_OPER_EDIT :pojo =edit(pojo);break;
            case MessageConstant.MESSAGE_OPER_DELETE :pojo =delete(pojo);break;
        }

        return pojo;
    }

    /**
     * 验证是否使用该operation
     * @param item
     * @return
     */
    public boolean check(MessageItem item) throws Exception {
        if(pojoName==null)
        {
            pojoName =dto.toPojo(item.getData()).getClass().getSimpleName();
        }

        if(pojoName.equals(item.getOperObjectName()))
        {
            return true;
        }

        return false;
    }

    @Autowired
    OperationUtil util;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        util.addOperation(this);
    }


}
