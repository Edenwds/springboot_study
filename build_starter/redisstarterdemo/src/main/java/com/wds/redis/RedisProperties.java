package com.wds.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: Wang Dengshou
 * @Description:
 * @Date: Created in 12:21 2018/9/23
 */
@ConfigurationProperties(prefix = "redis.msg")
public class RedisProperties {

    private String host;

    private int port;

    private int timeout;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
