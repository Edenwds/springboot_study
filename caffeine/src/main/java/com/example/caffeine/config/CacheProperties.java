package com.example.caffeine.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: wds
 * @Description: 缓存参数配置
 * @Date: created in 15:27 2018/12/29
 */
@ConfigurationProperties(prefix = "spring.cache")
public class CacheProperties {

    private int initialCapacity; //初始缓存空间大小
    private long maximnumSize; //缓存的最大条数
    private long maximunmWeight; //缓存的最大权重
    private long expireAfterAccess; //最后一次写入或访问后经过固定的时间过期
    private long expireAfterWrite; //最后一次写入后经过固定的时间过期
    private long refreshAfterWrite; //写入后经过固定的时间刷新缓存
    private boolean weakKeys; // key为弱引用
    private boolean weakValues; // value为弱引用
    private boolean softValues; //value 为软引用
    private boolean recordStats; //统计功能

    public int getInitialCapacity() {
        return initialCapacity;
    }

    public void setInitialCapacity(int initialCapacity) {
        this.initialCapacity = initialCapacity;
    }

    public long getMaximnumSize() {
        return maximnumSize;
    }

    public void setMaximnumSize(long maximnumSize) {
        this.maximnumSize = maximnumSize;
    }

    public long getMaximunmWeight() {
        return maximunmWeight;
    }

    public void setMaximunmWeight(long maximunmWeight) {
        this.maximunmWeight = maximunmWeight;
    }

    public long getExpireAfterAccess() {
        return expireAfterAccess;
    }

    public void setExpireAfterAccess(long expireAfterAccess) {
        this.expireAfterAccess = expireAfterAccess;
    }

    public long getExpireAfterWrite() {
        return expireAfterWrite;
    }

    public void setExpireAfterWrite(long expireAfterWrite) {
        this.expireAfterWrite = expireAfterWrite;
    }

    public long getRefreshAfterWrite() {
        return refreshAfterWrite;
    }

    public void setRefreshAfterWrite(long refreshAfterWrite) {
        this.refreshAfterWrite = refreshAfterWrite;
    }

    public boolean isWeakKeys() {
        return weakKeys;
    }

    public void setWeakKeys(boolean weakKeys) {
        this.weakKeys = weakKeys;
    }

    public boolean isWeakValues() {
        return weakValues;
    }

    public void setWeakValues(boolean weakValues) {
        this.weakValues = weakValues;
    }

    public boolean isSoftValues() {
        return softValues;
    }

    public void setSoftValues(boolean softValues) {
        this.softValues = softValues;
    }

    public boolean isRecordStats() {
        return recordStats;
    }

    public void setRecordStats(boolean recordStats) {
        this.recordStats = recordStats;
    }
}
