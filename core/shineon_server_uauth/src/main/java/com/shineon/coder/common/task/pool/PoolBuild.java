package com.shineon.coder.common.task.pool;

import com.shineon.coder.constant.PoolConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程池 创建
 */
@Component
@Configuration
@EnableAsync
public class PoolBuild {


    private final int corePoolSize =30;

    private  final  int maxPoolSize = 50;

    private int queueCapacity =200;

    private int keepAlive = 60;

    @Bean(PoolConstant.POOL_SCHEDULE)
    public Executor intervalExecutor()
    {
        System.out.println("init pool");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);

        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(PoolConstant.POOL_SCHEDULE);

        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setKeepAliveSeconds(keepAlive);

        executor.initialize();

        return executor;
    }
}
