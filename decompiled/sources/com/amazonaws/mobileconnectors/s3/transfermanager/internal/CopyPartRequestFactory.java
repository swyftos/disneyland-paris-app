package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.CopyPartRequest;

/* loaded from: classes2.dex */
public class CopyPartRequestFactory {
    private final CopyObjectRequest copyObjectRequest;
    private final long optimalPartSize;
    private long remainingBytes;
    private final String uploadId;
    private int partNumber = 1;
    private long offset = 0;

    public CopyPartRequestFactory(CopyObjectRequest copyObjectRequest, String str, long j, long j2) {
        this.copyObjectRequest = copyObjectRequest;
        this.uploadId = str;
        this.optimalPartSize = j;
        this.remainingBytes = j2;
    }

    public synchronized boolean hasMoreRequests() {
        return this.remainingBytes > 0;
    }

    public synchronized CopyPartRequest getNextCopyPartRequest() {
        CopyPartRequest copyPartRequestWithDestinationSSECustomerKey;
        long jMin = Math.min(this.optimalPartSize, this.remainingBytes);
        CopyPartRequest copyPartRequestWithUploadId = new CopyPartRequest().withSourceBucketName(this.copyObjectRequest.getSourceBucketName()).withSourceKey(this.copyObjectRequest.getSourceKey()).withUploadId(this.uploadId);
        int i = this.partNumber;
        this.partNumber = i + 1;
        copyPartRequestWithDestinationSSECustomerKey = copyPartRequestWithUploadId.withPartNumber(i).withDestinationBucketName(this.copyObjectRequest.getDestinationBucketName()).withDestinationKey(this.copyObjectRequest.getDestinationKey()).withSourceVersionId(this.copyObjectRequest.getSourceVersionId()).withFirstByte(new Long(this.offset)).withLastByte(new Long((this.offset + jMin) - 1)).withSourceSSECustomerKey(this.copyObjectRequest.getSourceSSECustomerKey()).withDestinationSSECustomerKey(this.copyObjectRequest.getDestinationSSECustomerKey());
        setOtherMetadataInRequest(copyPartRequestWithDestinationSSECustomerKey);
        this.offset += jMin;
        this.remainingBytes -= jMin;
        return copyPartRequestWithDestinationSSECustomerKey;
    }

    private void setOtherMetadataInRequest(CopyPartRequest copyPartRequest) {
        if (this.copyObjectRequest.getMatchingETagConstraints() != null) {
            copyPartRequest.setMatchingETagConstraints(this.copyObjectRequest.getMatchingETagConstraints());
        }
        if (this.copyObjectRequest.getModifiedSinceConstraint() != null) {
            copyPartRequest.setModifiedSinceConstraint(this.copyObjectRequest.getModifiedSinceConstraint());
        }
        if (this.copyObjectRequest.getNonmatchingETagConstraints() != null) {
            copyPartRequest.setNonmatchingETagConstraints(this.copyObjectRequest.getNonmatchingETagConstraints());
        }
        if (this.copyObjectRequest.getSourceVersionId() != null) {
            copyPartRequest.setSourceVersionId(this.copyObjectRequest.getSourceVersionId());
        }
        if (this.copyObjectRequest.getUnmodifiedSinceConstraint() != null) {
            copyPartRequest.setUnmodifiedSinceConstraint(this.copyObjectRequest.getUnmodifiedSinceConstraint());
        }
    }
}
