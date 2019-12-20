package com.shineon.coder.service.task;

import com.shineon.coder.kernel.constant.pool.PoolConstant;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class ControllerTask {


    @Async(PoolConstant.POOL_SCHEDULE)
    public void show()
    {
        while (true)
        {
            try {
                Thread.sleep(1000*3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("1111111111111111111111111111111111111111111111111");
        }
    }
}
