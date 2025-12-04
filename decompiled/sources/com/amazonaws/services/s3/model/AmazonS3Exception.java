package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonServiceException;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes2.dex */
public class AmazonS3Exception extends AmazonServiceException implements Serializable {
    private static final long serialVersionUID = 7573680383273658477L;
    private Map additionalDetails;
    private String cloudFrontId;
    private final String errorResponseXml;
    private String extendedRequestId;

    public AmazonS3Exception(String str) {
        super(str);
        this.errorResponseXml = null;
    }

    public AmazonS3Exception(String str, Exception exc) {
        super(str, exc);
        this.errorResponseXml = null;
    }

    public AmazonS3Exception(String str, String str2) {
        super(str);
        if (str2 == null) {
            throw new IllegalArgumentException("Error Response XML cannot be null");
        }
        this.errorResponseXml = str2;
    }

    public String getExtendedRequestId() {
        return this.extendedRequestId;
    }

    public void setExtendedRequestId(String str) {
        this.extendedRequestId = str;
    }

    public String getCloudFrontId() {
        return this.cloudFrontId;
    }

    public void setCloudFrontId(String str) {
        this.cloudFrontId = str;
    }

    public Map<String, String> getAdditionalDetails() {
        return this.additionalDetails;
    }

    public void setAdditionalDetails(Map<String, String> map) {
        this.additionalDetails = map;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + ", S3 Extended Request ID: " + getExtendedRequestId();
    }

    public String getErrorResponseXml() {
        return this.errorResponseXml;
    }
}
