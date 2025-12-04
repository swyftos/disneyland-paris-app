package com.amazonaws.services.s3.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ListObjectsV2Result {
    private String bucketName;
    private String continuationToken;
    private String delimiter;
    private String encodingType;
    private boolean isTruncated;
    private int keyCount;
    private int maxKeys;
    private String nextContinuationToken;
    private String prefix;
    private String startAfter;
    private List objectSummaries = new ArrayList();
    private List commonPrefixes = new ArrayList();

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public void setDelimiter(String str) {
        this.delimiter = str;
    }

    public String getEncodingType() {
        return this.encodingType;
    }

    public void setEncodingType(String str) {
        this.encodingType = str;
    }

    public String getContinuationToken() {
        return this.continuationToken;
    }

    public void setContinuationToken(String str) {
        this.continuationToken = str;
    }

    public String getNextContinuationToken() {
        return this.nextContinuationToken;
    }

    public void setNextContinuationToken(String str) {
        this.nextContinuationToken = str;
    }

    public int getKeyCount() {
        return this.keyCount;
    }

    public void setKeyCount(int i) {
        this.keyCount = i;
    }

    public int getMaxKeys() {
        return this.maxKeys;
    }

    public void setMaxKeys(int i) {
        this.maxKeys = i;
    }

    public String getStartAfter() {
        return this.startAfter;
    }

    public void setStartAfter(String str) {
        this.startAfter = str;
    }

    public List<S3ObjectSummary> getObjectSummaries() {
        return this.objectSummaries;
    }

    public List<String> getCommonPrefixes() {
        return this.commonPrefixes;
    }

    public void setCommonPrefixes(List<String> list) {
        this.commonPrefixes = list;
    }
}
