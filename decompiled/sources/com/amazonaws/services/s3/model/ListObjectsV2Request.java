package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: classes2.dex */
public class ListObjectsV2Request extends AmazonWebServiceRequest {
    private String bucketName;
    private String continuationToken;
    private String delimiter;
    private String encodingType;
    private boolean fetchOwner;
    private boolean isRequesterPays;
    private Integer maxKeys;
    private String prefix;
    private String startAfter;

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public ListObjectsV2Request withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public void setDelimiter(String str) {
        this.delimiter = str;
    }

    public ListObjectsV2Request withDelimiter(String str) {
        setDelimiter(str);
        return this;
    }

    public String getEncodingType() {
        return this.encodingType;
    }

    public void setEncodingType(String str) {
        this.encodingType = str;
    }

    public ListObjectsV2Request withEncodingType(String str) {
        setEncodingType(str);
        return this;
    }

    public Integer getMaxKeys() {
        return this.maxKeys;
    }

    public void setMaxKeys(Integer num) {
        this.maxKeys = num;
    }

    public ListObjectsV2Request withMaxKeys(Integer num) {
        setMaxKeys(num);
        return this;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public ListObjectsV2Request withPrefix(String str) {
        setPrefix(str);
        return this;
    }

    public String getContinuationToken() {
        return this.continuationToken;
    }

    public void setContinuationToken(String str) {
        this.continuationToken = str;
    }

    public ListObjectsV2Request withContinuationToken(String str) {
        setContinuationToken(str);
        return this;
    }

    public boolean isFetchOwner() {
        return this.fetchOwner;
    }

    public void setFetchOwner(boolean z) {
        this.fetchOwner = z;
    }

    public ListObjectsV2Request withFetchOwner(boolean z) {
        setFetchOwner(z);
        return this;
    }

    public String getStartAfter() {
        return this.startAfter;
    }

    public void setStartAfter(String str) {
        this.startAfter = str;
    }

    public ListObjectsV2Request withStartAfter(String str) {
        setStartAfter(str);
        return this;
    }

    public boolean isRequesterPays() {
        return this.isRequesterPays;
    }

    public void setRequesterPays(boolean z) {
        this.isRequesterPays = z;
    }

    public ListObjectsV2Request withRequesterPays(boolean z) {
        setRequesterPays(z);
        return this;
    }
}
