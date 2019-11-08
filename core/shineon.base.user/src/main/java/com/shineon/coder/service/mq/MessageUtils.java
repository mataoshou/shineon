package com.shineon.coder.service.mq;

import com.shineon.coder.kernel.constant.message.MessageConstant;
import org.springframework.stereotype.Service;

@Service
public class MessageUtils {

    public boolean senMessage(BaseMessage base,MessageItem item)
    {
        boolean success = false;
        int count = 0;

        while(!success)
        {
            if(count>= MessageConstant.MESSAGE_RETRY_COUNT)
            {
                return false;
            }
            base.output().send(null);
            count++;
        }

        return true;
    }
}
