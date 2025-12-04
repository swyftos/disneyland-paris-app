package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class CopyPartRequest extends AmazonWebServiceRequest implements Serializable, S3AccelerateUnsupported {
    private String destinationBucketName;
    private String destinationKey;
    private SSECustomerKey destinationSSECustomerKey;
    private Long firstByte;
    private Long lastByte;
    private Date modifiedSinceConstraint;
    private int partNumber;
    private String sourceBucketName;
    private String sourceKey;
    private SSECustomerKey sourceSSECustomerKey;
    private String sourceVersionId;
    private Date unmodifiedSinceConstraint;
    private String uploadId;
    private final List matchingETagConstraints = new ArrayList();
    private final List nonmatchingEtagConstraints = new ArrayList();

    public String getUploadId() {
        return this.uploadId;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    public CopyPartRequest withUploadId(String str) {
        this.uploadId = str;
        return this;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public void setPartNumber(int i) {
        this.partNumber = i;
    }

    public CopyPartRequest withPartNumber(int i) {
        this.partNumber = i;
        return this;
    }

    public String getSourceBucketName() {
        return this.sourceBucketName;
    }

    public void setSourceBucketName(String str) {
        this.sourceBucketName = str;
    }

    public CopyPartRequest withSourceBucketName(String str) {
        this.sourceBucketName = str;
        return this;
    }

    public String getSourceKey() {
        return this.sourceKey;
    }

    public void setSourceKey(String str) {
        this.sourceKey = str;
    }

    public CopyPartRequest withSourceKey(String str) {
        this.sourceKey = str;
        return this;
    }

    public String getSourceVersionId() {
        return this.sourceVersionId;
    }

    public void setSourceVersionId(String str) {
        this.sourceVersionId = str;
    }

    public CopyPartRequest withSourceVersionId(String str) {
        this.sourceVersionId = str;
        return this;
    }

    public String getDestinationBucketName() {
        return this.destinationBucketName;
    }

    public void setDestinationBucketName(String str) {
        this.destinationBucketName = str;
    }

    public CopyPartRequest withDestinationBucketName(String str) {
        setDestinationBucketName(str);
        return this;
    }

    public String getDestinationKey() {
        return this.destinationKey;
    }

    public void setDestinationKey(String str) {
        this.destinationKey = str;
    }

    public CopyPartRequest withDestinationKey(String str) {
        setDestinationKey(str);
        return this;
    }

    public Long getFirstByte() {
        return this.firstByte;
    }

    public void setFirstByte(Long l) {
        this.firstByte = l;
    }

    public CopyPartRequest withFirstByte(Long l) {
        this.firstByte = l;
        return this;
    }

    public Long getLastByte() {
        return this.lastByte;
    }

    public void setLastByte(Long l) {
        this.lastByte = l;
    }

    public CopyPartRequest withLastByte(Long l) {
        this.lastByte = l;
        return this;
    }

    public List<String> getMatchingETagConstraints() {
        return this.matchingETagConstraints;
    }

    public void setMatchingETagConstraints(List<String> list) {
        this.matchingETagConstraints.clear();
        this.matchingETagConstraints.addAll(list);
    }

    public CopyPartRequest withMatchingETagConstraints(List<String> list) {
        setMatchingETagConstraints(list);
        return this;
    }

    public CopyPartRequest withMatchingETagConstraint(String str) {
        this.matchingETagConstraints.add(str);
        return this;
    }

    public List<String> getNonmatchingETagConstraints() {
        return this.nonmatchingEtagConstraints;
    }

    public void setNonmatchingETagConstraints(List<String> list) {
        this.nonmatchingEtagConstraints.clear();
        this.nonmatchingEtagConstraints.addAll(list);
    }

    public CopyPartRequest withNonmatchingETagConstraints(List<String> list) {
        setNonmatchingETagConstraints(list);
        return this;
    }

    public CopyPartRequest withNonmatchingETagConstraint(String str) {
        this.nonmatchingEtagConstraints.add(str);
        return this;
    }

    public Date getUnmodifiedSinceConstraint() {
        return this.unmodifiedSinceConstraint;
    }

    public void setUnmodifiedSinceConstraint(Date date) {
        this.unmodifiedSinceConstraint = date;
    }

    public CopyPartRequest withUnmodifiedSinceConstraint(Date date) {
        setUnmodifiedSinceConstraint(date);
        return this;
    }

    public Date getModifiedSinceConstraint() {
        return this.modifiedSinceConstraint;
    }

    public void setModifiedSinceConstraint(Date date) {
        this.modifiedSinceConstraint = date;
    }

    public CopyPartRequest withModifiedSinceConstraint(Date date) {
        setModifiedSinceConstraint(date);
        return this;
    }

    public SSECustomerKey getSourceSSECustomerKey() {
        return this.sourceSSECustomerKey;
    }

    public void setSourceSSECustomerKey(SSECustomerKey sSECustomerKey) {
        this.sourceSSECustomerKey = sSECustomerKey;
    }

    public CopyPartRequest withSourceSSECustomerKey(SSECustomerKey sSECustomerKey) {
        setSourceSSECustomerKey(sSECustomerKey);
        return this;
    }

    public SSECustomerKey getDestinationSSECustomerKey() {
        return this.destinationSSECustomerKey;
    }

    public void setDestinationSSECustomerKey(SSECustomerKey sSECustomerKey) {
        this.destinationSSECustomerKey = sSECustomerKey;
    }

    public CopyPartRequest withDestinationSSECustomerKey(SSECustomerKey sSECustomerKey) {
        setDestinationSSECustomerKey(sSECustomerKey);
        return this;
    }
}
