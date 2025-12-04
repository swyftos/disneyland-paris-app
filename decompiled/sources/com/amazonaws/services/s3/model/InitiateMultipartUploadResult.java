package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.SSEResultBase;
import java.util.Date;

/* loaded from: classes2.dex */
public class InitiateMultipartUploadResult extends SSEResultBase {
    private Date abortDate;
    private String abortRuleId;
    private String bucketName;
    private boolean isRequesterCharged;
    private String key;
    private String uploadId;

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    public Date getAbortDate() {
        return this.abortDate;
    }

    public void setAbortDate(Date date) {
        this.abortDate = date;
    }

    public String getAbortRuleId() {
        return this.abortRuleId;
    }

    public void setAbortRuleId(String str) {
        this.abortRuleId = str;
    }

    public boolean isRequesterCharged() {
        return this.isRequesterCharged;
    }

    public void setRequesterCharged(boolean z) {
        this.isRequesterCharged = z;
    }
}
