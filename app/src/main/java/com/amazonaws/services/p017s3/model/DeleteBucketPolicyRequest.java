package com.amazonaws.services.p017s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class DeleteBucketPolicyRequest extends AmazonWebServiceRequest implements Serializable {
    private String bucketName;

    public DeleteBucketPolicyRequest(String str) {
        this.bucketName = str;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public DeleteBucketPolicyRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }
}
