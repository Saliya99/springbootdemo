package com.ictec.buisness;

public class URLConfig {
    private String url;

    URLConfig(String prefix, String host) {
        this.url = prefix + "://" + host;
    }

    URLConfig(String prefix, String host, String port) {
        this.url = prefix + "://" + host + ":" + port;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
