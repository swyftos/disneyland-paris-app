package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: classes2.dex */
public class SetBucketTaggingConfigurationRequest extends AmazonWebServiceRequest {
    private String bucketName;
    private BucketTaggingConfiguration taggingConfiguration;

    public SetBucketTaggingConfigurationRequest(String str, BucketTaggingConfiguration bucketTaggingConfiguration) {
        this.bucketName = str;
        this.taggingConfiguration = bucketTaggingConfiguration;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public SetBucketTaggingConfigurationRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public BucketTaggingConfiguration getTaggingConfiguration() {
        return this.taggingConfiguration;
    }

    public void setTaggingConfiguration(BucketTaggingConfiguration bucketTaggingConfiguration) {
        this.taggingConfiguration = bucketTaggingConfiguration;
    }

    public SetBucketTaggingConfigurationRequest withTaggingConfiguration(BucketTaggingConfiguration bucketTaggingConfiguration) {
        setTaggingConfiguration(bucketTaggingConfiguration);
        return this;
    }
}
