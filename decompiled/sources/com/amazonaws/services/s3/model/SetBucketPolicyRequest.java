package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: classes2.dex */
public class SetBucketPolicyRequest extends AmazonWebServiceRequest {
    private String bucketName;
    private String policyText;

    public SetBucketPolicyRequest(String str, String str2) {
        this.bucketName = str;
        this.policyText = str2;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public SetBucketPolicyRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public String getPolicyText() {
        return this.policyText;
    }

    public void setPolicyText(String str) {
        this.policyText = str;
    }

    public SetBucketPolicyRequest withPolicyText(String str) {
        setPolicyText(str);
        return this;
    }
}
