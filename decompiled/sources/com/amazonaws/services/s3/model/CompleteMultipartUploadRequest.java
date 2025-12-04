package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class CompleteMultipartUploadRequest extends AmazonWebServiceRequest implements Serializable {
    private String bucketName;
    private boolean isRequesterPays;
    private String key;
    private List partETags;
    private String uploadId;

    public CompleteMultipartUploadRequest() {
        this.partETags = new ArrayList();
    }

    public CompleteMultipartUploadRequest(String str, String str2, String str3, List<PartETag> list) {
        new ArrayList();
        this.bucketName = str;
        this.key = str2;
        this.uploadId = str3;
        this.partETags = list;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public CompleteMultipartUploadRequest withBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public CompleteMultipartUploadRequest withKey(String str) {
        this.key = str;
        return this;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    public CompleteMultipartUploadRequest withUploadId(String str) {
        this.uploadId = str;
        return this;
    }

    public List<PartETag> getPartETags() {
        return this.partETags;
    }

    public void setPartETags(List<PartETag> list) {
        this.partETags = list;
    }

    public CompleteMultipartUploadRequest withPartETags(List<PartETag> list) {
        setPartETags(list);
        return this;
    }

    public CompleteMultipartUploadRequest withPartETags(UploadPartResult... uploadPartResultArr) {
        for (UploadPartResult uploadPartResult : uploadPartResultArr) {
            this.partETags.add(new PartETag(uploadPartResult.getPartNumber(), uploadPartResult.getETag()));
        }
        return this;
    }

    public CompleteMultipartUploadRequest withPartETags(Collection<UploadPartResult> collection) {
        for (UploadPartResult uploadPartResult : collection) {
            this.partETags.add(new PartETag(uploadPartResult.getPartNumber(), uploadPartResult.getETag()));
        }
        return this;
    }

    public boolean isRequesterPays() {
        return this.isRequesterPays;
    }

    public void setRequesterPays(boolean z) {
        this.isRequesterPays = z;
    }

    public CompleteMultipartUploadRequest withRequesterPays(boolean z) {
        setRequesterPays(z);
        return this;
    }
}
