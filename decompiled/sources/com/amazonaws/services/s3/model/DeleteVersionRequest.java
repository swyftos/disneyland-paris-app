package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class DeleteVersionRequest extends AmazonWebServiceRequest implements Serializable {
    private String bucketName;
    private String key;
    private MultiFactorAuthentication mfa;
    private String versionId;

    public DeleteVersionRequest(String str, String str2, String str3) {
        this.bucketName = str;
        this.key = str2;
        this.versionId = str3;
    }

    public DeleteVersionRequest(String str, String str2, String str3, MultiFactorAuthentication multiFactorAuthentication) {
        this(str, str2, str3);
        this.mfa = multiFactorAuthentication;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public DeleteVersionRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public DeleteVersionRequest withKey(String str) {
        setKey(str);
        return this;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public void setVersionId(String str) {
        this.versionId = str;
    }

    public DeleteVersionRequest withVersionId(String str) {
        setVersionId(str);
        return this;
    }

    public MultiFactorAuthentication getMfa() {
        return this.mfa;
    }

    public void setMfa(MultiFactorAuthentication multiFactorAuthentication) {
        this.mfa = multiFactorAuthentication;
    }

    public DeleteVersionRequest withMfa(MultiFactorAuthentication multiFactorAuthentication) {
        setMfa(multiFactorAuthentication);
        return this;
    }
}
