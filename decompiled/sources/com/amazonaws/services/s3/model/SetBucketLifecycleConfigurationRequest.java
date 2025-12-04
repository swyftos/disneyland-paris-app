package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: classes2.dex */
public class SetBucketLifecycleConfigurationRequest extends AmazonWebServiceRequest {
    private String bucketName;
    private BucketLifecycleConfiguration lifecycleConfiguration;

    public SetBucketLifecycleConfigurationRequest(String str, BucketLifecycleConfiguration bucketLifecycleConfiguration) {
        this.bucketName = str;
        this.lifecycleConfiguration = bucketLifecycleConfiguration;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public SetBucketLifecycleConfigurationRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public BucketLifecycleConfiguration getLifecycleConfiguration() {
        return this.lifecycleConfiguration;
    }

    public void setLifecycleConfiguration(BucketLifecycleConfiguration bucketLifecycleConfiguration) {
        this.lifecycleConfiguration = bucketLifecycleConfiguration;
    }

    public SetBucketLifecycleConfigurationRequest withLifecycleConfiguration(BucketLifecycleConfiguration bucketLifecycleConfiguration) {
        setLifecycleConfiguration(bucketLifecycleConfiguration);
        return this;
    }
}
