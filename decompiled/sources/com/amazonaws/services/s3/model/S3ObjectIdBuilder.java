package com.amazonaws.services.s3.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class S3ObjectIdBuilder implements Serializable {
    private String bucket;
    private String key;
    private String versionId;

    public S3ObjectIdBuilder() {
    }

    public S3ObjectIdBuilder(S3ObjectId s3ObjectId) {
        this.bucket = s3ObjectId.getBucket();
        this.key = s3ObjectId.getKey();
        this.versionId = s3ObjectId.getVersionId();
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getKey() {
        return this.key;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public void setBucket(String str) {
        this.bucket = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setVersionId(String str) {
        this.versionId = str;
    }

    public S3ObjectIdBuilder withBucket(String str) {
        this.bucket = str;
        return this;
    }

    public S3ObjectIdBuilder withKey(String str) {
        this.key = str;
        return this;
    }

    public S3ObjectIdBuilder withVersionId(String str) {
        this.versionId = str;
        return this;
    }

    public S3ObjectId build() {
        return new S3ObjectId(this.bucket, this.key, this.versionId);
    }
}
