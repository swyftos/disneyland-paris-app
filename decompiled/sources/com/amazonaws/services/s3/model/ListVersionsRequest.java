package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: classes2.dex */
public class ListVersionsRequest extends AmazonWebServiceRequest {
    private String bucketName;
    private String delimiter;
    private String encodingType;
    private String keyMarker;
    private Integer maxResults;
    private String prefix;
    private String versionIdMarker;

    public ListVersionsRequest() {
    }

    public ListVersionsRequest(String str, String str2, String str3, String str4, String str5, Integer num) {
        setBucketName(str);
        setPrefix(str2);
        setKeyMarker(str3);
        setVersionIdMarker(str4);
        setDelimiter(str5);
        setMaxResults(num);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public ListVersionsRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public ListVersionsRequest withPrefix(String str) {
        setPrefix(str);
        return this;
    }

    public String getKeyMarker() {
        return this.keyMarker;
    }

    public void setKeyMarker(String str) {
        this.keyMarker = str;
    }

    public ListVersionsRequest withKeyMarker(String str) {
        setKeyMarker(str);
        return this;
    }

    public String getVersionIdMarker() {
        return this.versionIdMarker;
    }

    public void setVersionIdMarker(String str) {
        this.versionIdMarker = str;
    }

    public ListVersionsRequest withVersionIdMarker(String str) {
        setVersionIdMarker(str);
        return this;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public void setDelimiter(String str) {
        this.delimiter = str;
    }

    public ListVersionsRequest withDelimiter(String str) {
        setDelimiter(str);
        return this;
    }

    public Integer getMaxResults() {
        return this.maxResults;
    }

    public void setMaxResults(Integer num) {
        this.maxResults = num;
    }

    public ListVersionsRequest withMaxResults(Integer num) {
        setMaxResults(num);
        return this;
    }

    public String getEncodingType() {
        return this.encodingType;
    }

    public void setEncodingType(String str) {
        this.encodingType = str;
    }

    public ListVersionsRequest withEncodingType(String str) {
        setEncodingType(str);
        return this;
    }
}
