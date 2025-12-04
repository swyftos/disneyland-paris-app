package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: classes2.dex */
public class SetBucketLoggingConfigurationRequest extends AmazonWebServiceRequest {
    private String bucketName;
    private BucketLoggingConfiguration loggingConfiguration;

    public SetBucketLoggingConfigurationRequest(String str, BucketLoggingConfiguration bucketLoggingConfiguration) {
        this.bucketName = str;
        this.loggingConfiguration = bucketLoggingConfiguration;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public SetBucketLoggingConfigurationRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public BucketLoggingConfiguration getLoggingConfiguration() {
        return this.loggingConfiguration;
    }

    public void setLoggingConfiguration(BucketLoggingConfiguration bucketLoggingConfiguration) {
        this.loggingConfiguration = bucketLoggingConfiguration;
    }

    public SetBucketLoggingConfigurationRequest withLoggingConfiguration(BucketLoggingConfiguration bucketLoggingConfiguration) {
        setLoggingConfiguration(bucketLoggingConfiguration);
        return this;
    }
}
