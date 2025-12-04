package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: classes2.dex */
public class SetBucketCrossOriginConfigurationRequest extends AmazonWebServiceRequest {
    private String bucketName;
    private BucketCrossOriginConfiguration crossOriginConfiguration;

    public SetBucketCrossOriginConfigurationRequest(String str, BucketCrossOriginConfiguration bucketCrossOriginConfiguration) {
        this.bucketName = str;
        this.crossOriginConfiguration = bucketCrossOriginConfiguration;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public SetBucketCrossOriginConfigurationRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public BucketCrossOriginConfiguration getCrossOriginConfiguration() {
        return this.crossOriginConfiguration;
    }

    public void setCrossOriginConfiguration(BucketCrossOriginConfiguration bucketCrossOriginConfiguration) {
        this.crossOriginConfiguration = bucketCrossOriginConfiguration;
    }

    public SetBucketCrossOriginConfigurationRequest withCrossOriginConfiguration(BucketCrossOriginConfiguration bucketCrossOriginConfiguration) {
        setCrossOriginConfiguration(bucketCrossOriginConfiguration);
        return this;
    }
}
