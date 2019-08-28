package com.mg.coder.common.cache;


//@Component
//@Scope("prototype")

/**
 * 缓存锁对象
 *
 */
public class RedisLock {

    ///缓存目标
    private String key; //锁的key值
    private long overTime;//过期时间
    private long keepInterval;//维护锁持有状态，时间间隔

    private String lockType;//锁类型

    private Integer lockCount;//读锁个数
    private Integer lockMax;//读锁最大个数

    //锁状态  0未加锁   1正在获取锁   100加锁并使用中  -1失败状态
    private Short lockState;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getOverTime() {
        return overTime;
    }

    public void setOverTime(long overTime) {
        this.overTime = overTime;
    }

    public long getKeepInterval() {
        return keepInterval;
    }

    public void setKeepInterval(long keepInterval) {
        this.keepInterval = keepInterval;
    }

    public String getLockType() {
        return lockType;
    }

    public void setLockType(String lockType) {
        this.lockType = lockType;
    }

    public Integer getLockCount() {
        return lockCount;
    }

    public void setLockCount(Integer lockCount) {
        this.lockCount = lockCount;
    }

    public Integer getLockMax() {
        return lockMax;
    }

    public void setLockMax(Integer lockMax) {
        this.lockMax = lockMax;
    }

    public Short getLockState() {
        return lockState;
    }

    public void setLockState(Short lockState) {
        this.lockState = lockState;
    }
}
