package com.amazonaws.services.s3.model;

/* loaded from: classes2.dex */
public class RedirectRule {
    private String hostName;
    private String httpRedirectCode;
    private String protocol;
    private String replaceKeyPrefixWith;
    private String replaceKeyWith;

    public void setProtocol(String str) {
        this.protocol = str;
    }

    public String getprotocol() {
        return this.protocol;
    }

    public RedirectRule withProtocol(String str) {
        setProtocol(str);
        return this;
    }

    public void setHostName(String str) {
        this.hostName = str;
    }

    public String getHostName() {
        return this.hostName;
    }

    public RedirectRule withHostName(String str) {
        setHostName(str);
        return this;
    }

    public void setReplaceKeyPrefixWith(String str) {
        this.replaceKeyPrefixWith = str;
    }

    public String getReplaceKeyPrefixWith() {
        return this.replaceKeyPrefixWith;
    }

    public RedirectRule withReplaceKeyPrefixWith(String str) {
        setReplaceKeyPrefixWith(str);
        return this;
    }

    public void setReplaceKeyWith(String str) {
        this.replaceKeyWith = str;
    }

    public String getReplaceKeyWith() {
        return this.replaceKeyWith;
    }

    public RedirectRule withReplaceKeyWith(String str) {
        setReplaceKeyWith(str);
        return this;
    }

    public void setHttpRedirectCode(String str) {
        this.httpRedirectCode = str;
    }

    public String getHttpRedirectCode() {
        return this.httpRedirectCode;
    }

    public RedirectRule withHttpRedirectCode(String str) {
        this.httpRedirectCode = str;
        return this;
    }
}
