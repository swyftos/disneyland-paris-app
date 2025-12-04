package com.amazonaws.services.s3.model;

import androidx.media3.common.util.TimestampAdjuster;
import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class GetObjectRequest extends AmazonWebServiceRequest implements SSECustomerKeyProvider, Serializable {
    private com.amazonaws.event.ProgressListener generalProgressListener;
    private boolean isRequesterPays;
    private List matchingETagConstraints;
    private Date modifiedSinceConstraint;
    private List nonmatchingEtagConstraints;
    private Integer partNumber;
    private long[] range;
    private ResponseHeaderOverrides responseHeaders;
    private S3ObjectIdBuilder s3ObjectIdBuilder;
    private SSECustomerKey sseCustomerKey;
    private Date unmodifiedSinceConstraint;

    public GetObjectRequest(String str, String str2) {
        this(str, str2, (String) null);
    }

    public GetObjectRequest(String str, String str2, String str3) {
        this.s3ObjectIdBuilder = new S3ObjectIdBuilder();
        this.matchingETagConstraints = new ArrayList();
        this.nonmatchingEtagConstraints = new ArrayList();
        setBucketName(str);
        setKey(str2);
        setVersionId(str3);
    }

    public GetObjectRequest(S3ObjectId s3ObjectId) {
        this.s3ObjectIdBuilder = new S3ObjectIdBuilder();
        this.matchingETagConstraints = new ArrayList();
        this.nonmatchingEtagConstraints = new ArrayList();
        this.s3ObjectIdBuilder = new S3ObjectIdBuilder(s3ObjectId);
    }

    public GetObjectRequest(String str, String str2, boolean z) {
        this.s3ObjectIdBuilder = new S3ObjectIdBuilder();
        this.matchingETagConstraints = new ArrayList();
        this.nonmatchingEtagConstraints = new ArrayList();
        this.s3ObjectIdBuilder.withBucket(str).withKey(str2);
        this.isRequesterPays = z;
    }

    public String getBucketName() {
        return this.s3ObjectIdBuilder.getBucket();
    }

    public void setBucketName(String str) {
        this.s3ObjectIdBuilder.setBucket(str);
    }

    public GetObjectRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public String getKey() {
        return this.s3ObjectIdBuilder.getKey();
    }

    public void setKey(String str) {
        this.s3ObjectIdBuilder.setKey(str);
    }

    public GetObjectRequest withKey(String str) {
        setKey(str);
        return this;
    }

    public String getVersionId() {
        return this.s3ObjectIdBuilder.getVersionId();
    }

    public void setVersionId(String str) {
        this.s3ObjectIdBuilder.setVersionId(str);
    }

    public GetObjectRequest withVersionId(String str) {
        setVersionId(str);
        return this;
    }

    public long[] getRange() {
        long[] jArr = this.range;
        if (jArr == null) {
            return null;
        }
        return (long[]) jArr.clone();
    }

    public void setRange(long j, long j2) {
        this.range = new long[]{j, j2};
    }

    public void setRange(long j) {
        setRange(j, TimestampAdjuster.MODE_SHARED);
    }

    public GetObjectRequest withRange(long j, long j2) {
        setRange(j, j2);
        return this;
    }

    public GetObjectRequest withRange(long j) {
        setRange(j);
        return this;
    }

    public List<String> getMatchingETagConstraints() {
        return this.matchingETagConstraints;
    }

    public void setMatchingETagConstraints(List<String> list) {
        this.matchingETagConstraints = list;
    }

    public GetObjectRequest withMatchingETagConstraint(String str) {
        this.matchingETagConstraints.add(str);
        return this;
    }

    public List<String> getNonmatchingETagConstraints() {
        return this.nonmatchingEtagConstraints;
    }

    public void setNonmatchingETagConstraints(List<String> list) {
        this.nonmatchingEtagConstraints = list;
    }

    public GetObjectRequest withNonmatchingETagConstraint(String str) {
        this.nonmatchingEtagConstraints.add(str);
        return this;
    }

    public Date getUnmodifiedSinceConstraint() {
        return this.unmodifiedSinceConstraint;
    }

    public void setUnmodifiedSinceConstraint(Date date) {
        this.unmodifiedSinceConstraint = date;
    }

    public GetObjectRequest withUnmodifiedSinceConstraint(Date date) {
        setUnmodifiedSinceConstraint(date);
        return this;
    }

    public Date getModifiedSinceConstraint() {
        return this.modifiedSinceConstraint;
    }

    public void setModifiedSinceConstraint(Date date) {
        this.modifiedSinceConstraint = date;
    }

    public GetObjectRequest withModifiedSinceConstraint(Date date) {
        setModifiedSinceConstraint(date);
        return this;
    }

    public ResponseHeaderOverrides getResponseHeaders() {
        return this.responseHeaders;
    }

    public void setResponseHeaders(ResponseHeaderOverrides responseHeaderOverrides) {
        this.responseHeaders = responseHeaderOverrides;
    }

    public GetObjectRequest withResponseHeaders(ResponseHeaderOverrides responseHeaderOverrides) {
        setResponseHeaders(responseHeaderOverrides);
        return this;
    }

    @Deprecated
    public void setProgressListener(ProgressListener progressListener) {
        setGeneralProgressListener(new LegacyS3ProgressListener(progressListener));
    }

    @Deprecated
    public ProgressListener getProgressListener() {
        com.amazonaws.event.ProgressListener progressListener = this.generalProgressListener;
        if (progressListener instanceof LegacyS3ProgressListener) {
            return ((LegacyS3ProgressListener) progressListener).unwrap();
        }
        return null;
    }

    @Deprecated
    public GetObjectRequest withProgressListener(ProgressListener progressListener) {
        setProgressListener(progressListener);
        return this;
    }

    @Override // com.amazonaws.AmazonWebServiceRequest
    public void setGeneralProgressListener(com.amazonaws.event.ProgressListener progressListener) {
        this.generalProgressListener = progressListener;
    }

    @Override // com.amazonaws.AmazonWebServiceRequest
    public com.amazonaws.event.ProgressListener getGeneralProgressListener() {
        return this.generalProgressListener;
    }

    @Override // com.amazonaws.AmazonWebServiceRequest
    public GetObjectRequest withGeneralProgressListener(com.amazonaws.event.ProgressListener progressListener) {
        setGeneralProgressListener(progressListener);
        return this;
    }

    public boolean isRequesterPays() {
        return this.isRequesterPays;
    }

    public void setRequesterPays(boolean z) {
        this.isRequesterPays = z;
    }

    public GetObjectRequest withRequesterPays(boolean z) {
        setRequesterPays(z);
        return this;
    }

    @Override // com.amazonaws.services.s3.model.SSECustomerKeyProvider
    public SSECustomerKey getSSECustomerKey() {
        return this.sseCustomerKey;
    }

    public void setSSECustomerKey(SSECustomerKey sSECustomerKey) {
        this.sseCustomerKey = sSECustomerKey;
    }

    public GetObjectRequest withSSECustomerKey(SSECustomerKey sSECustomerKey) {
        setSSECustomerKey(sSECustomerKey);
        return this;
    }

    public Integer getPartNumber() {
        return this.partNumber;
    }

    public void setPartNumber(Integer num) {
        this.partNumber = num;
    }

    public GetObjectRequest withPartNumber(Integer num) {
        setPartNumber(num);
        return this;
    }

    public S3ObjectId getS3ObjectId() {
        return this.s3ObjectIdBuilder.build();
    }

    public void setS3ObjectId(S3ObjectId s3ObjectId) {
        this.s3ObjectIdBuilder = new S3ObjectIdBuilder(s3ObjectId);
    }

    public GetObjectRequest withS3ObjectId(S3ObjectId s3ObjectId) {
        setS3ObjectId(s3ObjectId);
        return this;
    }
}
