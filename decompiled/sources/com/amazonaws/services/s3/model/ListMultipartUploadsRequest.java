package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: classes2.dex */
public class ListMultipartUploadsRequest extends AmazonWebServiceRequest {
    private String bucketName;
    private String delimiter;
    private String encodingType;
    private String keyMarker;
    private Integer maxUploads;
    private String prefix;
    private String uploadIdMarker;

    public ListMultipartUploadsRequest(String str) {
        this.bucketName = str;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public ListMultipartUploadsRequest withBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public Integer getMaxUploads() {
        return this.maxUploads;
    }

    public void setMaxUploads(Integer num) {
        this.maxUploads = num;
    }

    public ListMultipartUploadsRequest withMaxUploads(int i) {
        this.maxUploads = Integer.valueOf(i);
        return this;
    }

    public String getKeyMarker() {
        return this.keyMarker;
    }

    public void setKeyMarker(String str) {
        this.keyMarker = str;
    }

    public ListMultipartUploadsRequest withKeyMarker(String str) {
        this.keyMarker = str;
        return this;
    }

    public String getUploadIdMarker() {
        return this.uploadIdMarker;
    }

    public void setUploadIdMarker(String str) {
        this.uploadIdMarker = str;
    }

    public ListMultipartUploadsRequest withUploadIdMarker(String str) {
        this.uploadIdMarker = str;
        return this;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public void setDelimiter(String str) {
        this.delimiter = str;
    }

    public ListMultipartUploadsRequest withDelimiter(String str) {
        setDelimiter(str);
        return this;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public ListMultipartUploadsRequest withPrefix(String str) {
        setPrefix(str);
        return this;
    }

    public String getEncodingType() {
        return this.encodingType;
    }

    public void setEncodingType(String str) {
        this.encodingType = str;
    }

    public ListMultipartUploadsRequest withEncodingType(String str) {
        setEncodingType(str);
        return this;
    }
}
