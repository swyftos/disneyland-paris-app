package com.amazonaws.services.s3.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class VersionListing {
    private String bucketName;
    private String delimiter;
    private String encodingType;
    private boolean isTruncated;
    private String keyMarker;
    private int maxKeys;
    private String nextKeyMarker;
    private String nextVersionIdMarker;
    private String prefix;
    private String versionIdMarker;
    private List versionSummaries = new ArrayList();
    private List commonPrefixes = new ArrayList();

    public List<S3VersionSummary> getVersionSummaries() {
        return this.versionSummaries;
    }

    public void setVersionSummaries(List<S3VersionSummary> list) {
        this.versionSummaries = list;
    }

    public List<String> getCommonPrefixes() {
        return this.commonPrefixes;
    }

    public void setCommonPrefixes(List<String> list) {
        this.commonPrefixes = list;
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

    public String getKeyMarker() {
        return this.keyMarker;
    }

    public void setKeyMarker(String str) {
        this.keyMarker = str;
    }

    public String getVersionIdMarker() {
        return this.versionIdMarker;
    }

    public void setVersionIdMarker(String str) {
        this.versionIdMarker = str;
    }

    public int getMaxKeys() {
        return this.maxKeys;
    }

    public void setMaxKeys(int i) {
        this.maxKeys = i;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public void setDelimiter(String str) {
        this.delimiter = str;
    }

    public String getNextKeyMarker() {
        return this.nextKeyMarker;
    }

    public void setNextKeyMarker(String str) {
        this.nextKeyMarker = str;
    }

    public String getNextVersionIdMarker() {
        return this.nextVersionIdMarker;
    }

    public void setNextVersionIdMarker(String str) {
        this.nextVersionIdMarker = str;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }

    public String getEncodingType() {
        return this.encodingType;
    }

    public void setEncodingType(String str) {
        this.encodingType = str;
    }
}
