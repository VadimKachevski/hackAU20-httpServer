package com.hackau20.httpserver.config;

public class Configuration {
    private int port ;
    private String webroot;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setWebroot(String webroot) {
        this.webroot = webroot;
    }

    public String getWebroot() {
        return webroot;
    }
}
