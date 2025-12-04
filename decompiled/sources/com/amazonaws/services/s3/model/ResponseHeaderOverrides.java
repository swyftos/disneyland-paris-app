package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: classes2.dex */
public class ResponseHeaderOverrides extends AmazonWebServiceRequest {
    private String cacheControl;
    private String contentDisposition;
    private String contentEncoding;
    private String contentLanguage;
    private String contentType;
    private String expires;
    public static final String RESPONSE_HEADER_CACHE_CONTROL = "response-cache-control";
    public static final String RESPONSE_HEADER_CONTENT_DISPOSITION = "response-content-disposition";
    public static final String RESPONSE_HEADER_CONTENT_ENCODING = "response-content-encoding";
    public static final String RESPONSE_HEADER_CONTENT_LANGUAGE = "response-content-language";
    public static final String RESPONSE_HEADER_CONTENT_TYPE = "response-content-type";
    public static final String RESPONSE_HEADER_EXPIRES = "response-expires";
    private static final String[] PARAMETER_ORDER = {RESPONSE_HEADER_CACHE_CONTROL, RESPONSE_HEADER_CONTENT_DISPOSITION, RESPONSE_HEADER_CONTENT_ENCODING, RESPONSE_HEADER_CONTENT_LANGUAGE, RESPONSE_HEADER_CONTENT_TYPE, RESPONSE_HEADER_EXPIRES};

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public ResponseHeaderOverrides withContentType(String str) {
        setContentType(str);
        return this;
    }

    public String getContentLanguage() {
        return this.contentLanguage;
    }

    public void setContentLanguage(String str) {
        this.contentLanguage = str;
    }

    public ResponseHeaderOverrides withContentLanguage(String str) {
        setContentLanguage(str);
        return this;
    }

    public String getExpires() {
        return this.expires;
    }

    public void setExpires(String str) {
        this.expires = str;
    }

    public ResponseHeaderOverrides withExpires(String str) {
        setExpires(str);
        return this;
    }

    public String getCacheControl() {
        return this.cacheControl;
    }

    public void setCacheControl(String str) {
        this.cacheControl = str;
    }

    public ResponseHeaderOverrides withCacheControl(String str) {
        setCacheControl(str);
        return this;
    }

    public String getContentDisposition() {
        return this.contentDisposition;
    }

    public void setContentDisposition(String str) {
        this.contentDisposition = str;
    }

    public ResponseHeaderOverrides withContentDisposition(String str) {
        setContentDisposition(str);
        return this;
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public void setContentEncoding(String str) {
        this.contentEncoding = str;
    }

    public ResponseHeaderOverrides withContentEncoding(String str) {
        setContentEncoding(str);
        return this;
    }
}
