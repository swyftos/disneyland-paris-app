package com.amazonaws.mobileconnectors.s3.transfermanager.model;

@Deprecated
/* loaded from: classes2.dex */
public class CopyResult {
    private String destinationBucketName;
    private String destinationKey;
    private String eTag;
    private String sourceBucketName;
    private String sourceKey;
    private String versionId;

    public String getSourceBucketName() {
        return this.sourceBucketName;
    }

    public void setSourceBucketName(String str) {
        this.sourceBucketName = str;
    }

    public String getSourceKey() {
        return this.sourceKey;
    }

    public void setSourceKey(String str) {
        this.sourceKey = str;
    }

    public String getDestinationBucketName() {
        return this.destinationBucketName;
    }

    public void setDestinationBucketName(String str) {
        this.destinationBucketName = str;
    }

    public String getDestinationKey() {
        return this.destinationKey;
    }

    public void setDestinationKey(String str) {
        this.destinationKey = str;
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
