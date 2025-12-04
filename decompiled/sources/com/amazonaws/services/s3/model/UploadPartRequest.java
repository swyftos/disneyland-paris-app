package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class UploadPartRequest extends AmazonWebServiceRequest implements SSECustomerKeyProvider, S3DataSource, Serializable {
    private static final long serialVersionUID = 1;
    private String bucketName;
    private File file;
    private long fileOffset;
    private int id;
    private transient InputStream inputStream;
    private boolean isLastPart;
    private boolean isRequesterPays;
    private String key;
    private int mainUploadId;
    private String md5Digest;
    private ObjectMetadata objectMetadata;
    private int partNumber;
    private long partSize;
    private SSECustomerKey sseCustomerKey;
    private String uploadId;

    public void setId(int i) {
        this.id = i;
    }

    public int getId() {
        return this.id;
    }

    public UploadPartRequest withId(int i) {
        this.id = i;
        return this;
    }

    public void setMainUploadId(int i) {
        this.mainUploadId = i;
    }

    public int getMainUploadId() {
        return this.mainUploadId;
    }

    public UploadPartRequest withMainUploadId(int i) {
        this.mainUploadId = i;
        return this;
    }

    @Override // com.amazonaws.services.s3.model.S3DataSource
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override // com.amazonaws.services.s3.model.S3DataSource
    public InputStream getInputStream() {
        return this.inputStream;
    }

    public UploadPartRequest withInputStream(InputStream inputStream) {
        setInputStream(inputStream);
        return this;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public UploadPartRequest withBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public UploadPartRequest withKey(String str) {
        this.key = str;
        return this;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    public UploadPartRequest withUploadId(String str) {
        this.uploadId = str;
        return this;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public void setPartNumber(int i) {
        this.partNumber = i;
    }

    public UploadPartRequest withPartNumber(int i) {
        this.partNumber = i;
        return this;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public void setPartSize(long j) {
        this.partSize = j;
    }

    public UploadPartRequest withPartSize(long j) {
        this.partSize = j;
        return this;
    }

    public String getMd5Digest() {
        return this.md5Digest;
    }

    public void setMd5Digest(String str) {
        this.md5Digest = str;
    }

    public UploadPartRequest withMD5Digest(String str) {
        this.md5Digest = str;
        return this;
    }

    @Override // com.amazonaws.services.s3.model.S3DataSource
    public File getFile() {
        return this.file;
    }

    @Override // com.amazonaws.services.s3.model.S3DataSource
    public void setFile(File file) {
        this.file = file;
    }

    public UploadPartRequest withFile(File file) {
        setFile(file);
        return this;
    }

    public long getFileOffset() {
        return this.fileOffset;
    }

    public void setFileOffset(long j) {
        this.fileOffset = j;
    }

    public UploadPartRequest withFileOffset(long j) {
        setFileOffset(j);
        return this;
    }

    @Deprecated
    public void setProgressListener(ProgressListener progressListener) {
        setGeneralProgressListener(new LegacyS3ProgressListener(progressListener));
    }

    @Deprecated
    public ProgressListener getProgressListener() {
        com.amazonaws.event.ProgressListener generalProgressListener = getGeneralProgressListener();
        if (generalProgressListener instanceof LegacyS3ProgressListener) {
            return ((LegacyS3ProgressListener) generalProgressListener).unwrap();
        }
        return null;
    }

    @Deprecated
    public UploadPartRequest withProgressListener(ProgressListener progressListener) {
        setProgressListener(progressListener);
        return this;
    }

    public boolean isLastPart() {
        return this.isLastPart;
    }

    public void setLastPart(boolean z) {
        this.isLastPart = z;
    }

    public UploadPartRequest withLastPart(boolean z) {
        setLastPart(z);
        return this;
    }

    @Override // com.amazonaws.services.s3.model.SSECustomerKeyProvider
    public SSECustomerKey getSSECustomerKey() {
        return this.sseCustomerKey;
    }

    public void setSSECustomerKey(SSECustomerKey sSECustomerKey) {
        this.sseCustomerKey = sSECustomerKey;
    }

    public UploadPartRequest withSSECustomerKey(SSECustomerKey sSECustomerKey) {
        setSSECustomerKey(sSECustomerKey);
        return this;
    }

    public ObjectMetadata getObjectMetadata() {
        return this.objectMetadata;
    }

    public void setObjectMetadata(ObjectMetadata objectMetadata) {
        this.objectMetadata = objectMetadata;
    }

    public UploadPartRequest withObjectMetadata(ObjectMetadata objectMetadata) {
        setObjectMetadata(objectMetadata);
        return this;
    }

    public boolean isRequesterPays() {
        return this.isRequesterPays;
    }

    public void setRequesterPays(boolean z) {
        this.isRequesterPays = z;
    }

    public UploadPartRequest withRequesterPays(boolean z) {
        setRequesterPays(z);
        return this;
    }
}
