package com.example.guava.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description:
 * @Date: created in 14:39 2018/10/8
 */

@ConfigurationProperties(prefix = "guava.cache.config")
public class GuavaProperties {

    private long maximumSize;

    private long maximumWeight;

    private long expireAfterAccessDuration;

    private long expireAfterWriteDuration;

    private long refreshDuration;

    private int initialCapacity;

    private int concurrencyLevel;

    public long getMaximumSize() {
        return maximumSize;
    }

    public void setMaximumSize(long maximumSize) {
        this.maximumSize = maximumSize;
    }

    public long getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(long maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    public long getExpireAfterAccessDuration() {
        return expireAfterAccessDuration;
    }

    public void setExpireAfterAccessDuration(long expireAfterAccessDuration) {
        this.expireAfterAccessDuration = expireAfterAccessDuration;
    }

    public long getExpireAfterWriteDuration() {
        return expireAfterWriteDuration;
    }

    public void setExpireAfterWriteDuration(long expireAfterWriteDuration) {
        this.expireAfterWriteDuration = expireAfterWriteDuration;
    }

    public long getRefreshDuration() {
        return refreshDuration;
    }

    public void setRefreshDuration(long refreshDuration) {
        this.refreshDuration = refreshDuration;
    }

    public int getInitialCapacity() {
        return initialCapacity;
    }

    public void setInitialCapacity(int initialCapacity) {
        this.initialCapacity = initialCapacity;
    }

    public int getConcurrencyLevel() {
        return concurrencyLevel;
    }

    public void setConcurrencyLevel(int concurrencyLevel) {
        this.concurrencyLevel = concurrencyLevel;
    }
}
