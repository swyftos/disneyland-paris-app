package com.amazonaws.services.s3.model;

import ch.qos.logback.core.CoreConstants;
import java.util.Date;

/* loaded from: classes2.dex */
public class S3ObjectSummary {
    protected String bucketName;
    protected String eTag;
    protected String key;
    protected Date lastModified;
    protected Owner owner;
    protected long size;
    protected String storageClass;

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

    public String getETag() {
        return this.eTag;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(Date date) {
        this.lastModified = date;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public String toString() {
        return "S3ObjectSummary{bucketName='" + this.bucketName + CoreConstants.SINGLE_QUOTE_CHAR + ", key='" + this.key + CoreConstants.SINGLE_QUOTE_CHAR + ", eTag='" + this.eTag + CoreConstants.SINGLE_QUOTE_CHAR + ", size=" + this.size + ", lastModified=" + this.lastModified + ", storageClass='" + this.storageClass + CoreConstants.SINGLE_QUOTE_CHAR + ", owner=" + this.owner + '}';
    }
}
