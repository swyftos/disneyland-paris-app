package com.amazonaws.mobileconnectors.s3.transfermanager.model;

@Deprecated
/* loaded from: classes2.dex */
public class UploadResult {
    private String bucketName;
    private String eTag;
    private String key;
    private String versionId;

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getETag() {
        return this.eTag;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public void setVersionId(String str) {
        this.versionId = str;
    }
}
