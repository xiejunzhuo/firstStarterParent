package com.xjz.study.starter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Description:
 * User: Administrator
 * Date: 2021-01-27
 * Time: 10:52
 */
@ConfigurationProperties(prefix = "xjz.redisson")
public class RedissonDemoProperties {

    private String host = "127.0.0.1";
    private String port = "6739";
    private int timeout;
    private boolean ssl;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }
}
