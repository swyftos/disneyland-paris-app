package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class GetObjectAclRequest extends AmazonWebServiceRequest implements Serializable {
    private boolean isRequesterPays;
    private S3ObjectIdBuilder s3ObjectIdBuilder;

    public GetObjectAclRequest(String str, String str2) {
        this(str, str2, null);
    }

    public GetObjectAclRequest(String str, String str2, String str3) {
        this.s3ObjectIdBuilder = new S3ObjectIdBuilder();
        setBucketName(str);
        setKey(str2);
        setVersionId(str3);
    }

    public String getBucketName() {
        return this.s3ObjectIdBuilder.getBucket();
    }

    public void setBucketName(String str) {
        this.s3ObjectIdBuilder.setBucket(str);
    }

    public GetObjectAclRequest withBucket(String str) {
        setBucketName(str);
        return this;
    }

    public String getKey() {
        return this.s3ObjectIdBuilder.getKey();
    }

    public void setKey(String str) {
        this.s3ObjectIdBuilder.setKey(str);
    }

    public GetObjectAclRequest withKey(String str) {
        setKey(str);
        return this;
    }

    public String getVersionId() {
        return this.s3ObjectIdBuilder.getVersionId();
    }

    public void setVersionId(String str) {
        this.s3ObjectIdBuilder.setVersionId(str);
    }

    public GetObjectAclRequest withVersionId(String str) {
        setVersionId(str);
        return this;
    }

    public boolean isRequesterPays() {
        return this.isRequesterPays;
    }

    public void setRequesterPays(boolean z) {
        this.isRequesterPays = z;
    }

    public GetObjectAclRequest withRequesterPays(boolean z) {
        setRequesterPays(z);
        return this;
    }
}
