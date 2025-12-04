package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: classes2.dex */
public class ListPartsRequest extends AmazonWebServiceRequest {
    private String bucketName;
    private String encodingType;
    private boolean isRequesterPays;
    private String key;
    private Integer maxParts;
    private Integer partNumberMarker;
    private String uploadId;

    public ListPartsRequest(String str, String str2, String str3) {
        this.bucketName = str;
        this.key = str2;
        this.uploadId = str3;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public ListPartsRequest withBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public ListPartsRequest withKey(String str) {
        this.key = str;
        return this;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    public ListPartsRequest withUploadId(String str) {
        this.uploadId = str;
        return this;
    }

    public Integer getMaxParts() {
        return this.maxParts;
    }

    public void setMaxParts(int i) {
        this.maxParts = Integer.valueOf(i);
    }

    public ListPartsRequest withMaxParts(int i) {
        this.maxParts = Integer.valueOf(i);
        return this;
    }

    public Integer getPartNumberMarker() {
        return this.partNumberMarker;
    }

    public void setPartNumberMarker(Integer num) {
        this.partNumberMarker = num;
    }

    public ListPartsRequest withPartNumberMarker(Integer num) {
        this.partNumberMarker = num;
        return this;
    }

    public String getEncodingType() {
        return this.encodingType;
    }

    public void setEncodingType(String str) {
        this.encodingType = str;
    }

    public ListPartsRequest withEncodingType(String str) {
        setEncodingType(str);
        return this;
    }

    public boolean isRequesterPays() {
        return this.isRequesterPays;
    }

    public void setRequesterPays(boolean z) {
        this.isRequesterPays = z;
    }

    public ListPartsRequest withRequesterPays(boolean z) {
        setRequesterPays(z);
        return this;
    }
}
