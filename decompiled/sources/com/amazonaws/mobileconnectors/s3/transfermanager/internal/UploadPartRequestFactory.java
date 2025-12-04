package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.services.s3.internal.InputSubstream;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.SSECustomerKey;
import com.amazonaws.services.s3.model.UploadPartRequest;
import java.io.File;

/* loaded from: classes2.dex */
public class UploadPartRequestFactory {
    private final String bucketName;
    private final File file;
    private final String key;
    private final long optimalPartSize;
    private final PutObjectRequest putObjectRequest;
    private long remainingBytes;
    private SSECustomerKey sseCustomerKey;
    private final String uploadId;
    private int partNumber = 1;
    private long offset = 0;

    public UploadPartRequestFactory(PutObjectRequest putObjectRequest, String str, long j) {
        this.putObjectRequest = putObjectRequest;
        this.uploadId = str;
        this.optimalPartSize = j;
        this.bucketName = putObjectRequest.getBucketName();
        this.key = putObjectRequest.getKey();
        this.file = TransferManagerUtils.getRequestFile(putObjectRequest);
        this.remainingBytes = TransferManagerUtils.getContentLength(putObjectRequest);
        this.sseCustomerKey = putObjectRequest.getSSECustomerKey();
    }

    public synchronized boolean hasMoreRequests() {
        return this.remainingBytes > 0;
    }

    public synchronized UploadPartRequest getNextUploadPartRequest() {
        UploadPartRequest uploadPartRequestWithPartSize;
        try {
            long jMin = Math.min(this.optimalPartSize, this.remainingBytes);
            boolean z = this.remainingBytes - jMin <= 0;
            if (this.putObjectRequest.getInputStream() != null) {
                UploadPartRequest uploadPartRequestWithInputStream = new UploadPartRequest().withBucketName(this.bucketName).withKey(this.key).withUploadId(this.uploadId).withInputStream(new InputSubstream(this.putObjectRequest.getInputStream(), 0L, jMin, z));
                int i = this.partNumber;
                this.partNumber = i + 1;
                uploadPartRequestWithPartSize = uploadPartRequestWithInputStream.withPartNumber(i).withPartSize(jMin);
            } else {
                UploadPartRequest uploadPartRequestWithFileOffset = new UploadPartRequest().withBucketName(this.bucketName).withKey(this.key).withUploadId(this.uploadId).withFile(this.file).withFileOffset(this.offset);
                int i2 = this.partNumber;
                this.partNumber = i2 + 1;
                uploadPartRequestWithPartSize = uploadPartRequestWithFileOffset.withPartNumber(i2).withPartSize(jMin);
            }
            SSECustomerKey sSECustomerKey = this.sseCustomerKey;
            if (sSECustomerKey != null) {
                uploadPartRequestWithPartSize.setSSECustomerKey(sSECustomerKey);
            }
            this.offset += jMin;
            this.remainingBytes -= jMin;
            uploadPartRequestWithPartSize.setLastPart(z);
            uploadPartRequestWithPartSize.setGeneralProgressListener(this.putObjectRequest.getGeneralProgressListener());
        } catch (Throwable th) {
            throw th;
        }
        return uploadPartRequestWithPartSize;
    }
}
