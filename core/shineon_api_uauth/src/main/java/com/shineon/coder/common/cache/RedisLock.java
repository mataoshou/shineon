package com.shineon.coder.common.cache;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Scope("prototype")

/**
 * 缓存锁对象
 *
 */
public class RedisLock {

    ///缓存目标
    private String key;

    ///缓存读锁
    private String readLockKey;
    private Integer readLock;
    private Integer readCount;//读锁个数
    private Integer readMax;//读锁最大个数

    ///缓存写锁
    private String writeLockKey;
    private Integer writeLock;
    private Integer writeCount;//写锁个数
    private Integer writeMax;//写锁最大个数

    ///独占锁
    private String sycLockKey;
    private Integer sycLock;


}
