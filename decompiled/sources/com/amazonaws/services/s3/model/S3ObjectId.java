package com.amazonaws.services.s3.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class S3ObjectId implements Serializable {
    private final String bucket;
    private final String key;
    private final String versionId;

    public S3ObjectId(String str, String str2) {
        this(str, str2, null);
    }

    public S3ObjectId(String str, String str2, String str3) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("bucket and key must be specified");
        }
        this.bucket = str;
        this.key = str2;
        this.versionId = str3;
    }

    public S3ObjectId(S3ObjectIdBuilder s3ObjectIdBuilder) {
        this.bucket = s3ObjectIdBuilder.getBucket();
        this.key = s3ObjectIdBuilder.getKey();
        this.versionId = s3ObjectIdBuilder.getVersionId();
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

    public InstructionFileId instructionFileId() {
        return instructionFileId(null);
    }

    public InstructionFileId instructionFileId(String str) {
        String str2 = this.key + InstructionFileId.DOT;
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        if (str == null || str.trim().length() == 0) {
            str = "instruction";
        }
        sb.append(str);
        return new InstructionFileId(this.bucket, sb.toString(), this.versionId);
    }

    public String toString() {
        return "bucket: " + this.bucket + ", key: " + this.key + ", versionId: " + this.versionId;
    }
}
