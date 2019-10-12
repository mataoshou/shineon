package com.shineon.coder.service.task;

import com.shineon.coder.kernel.constant.PoolConstant;
import com.shineon.coder.service.cache.SysCache;
import com.shineon.coder.service.convert.CommonItem;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
@Slf4j
public class SysTask {



    @Scheduled(fixedRate = 1000*10)
    @Async(PoolConstant.POOL_SCHEDULE)
    public void intervalBuild() throws Exception {

        log.info("开始清理缓存数据");
        SysCache.single.cleanOverTime();
    }
}
