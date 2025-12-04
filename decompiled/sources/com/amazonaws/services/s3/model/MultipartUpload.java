package com.amazonaws.services.s3.model;

import java.util.Date;

/* loaded from: classes2.dex */
public class MultipartUpload {
    private Date initiated;
    private Owner initiator;
    private String key;
    private Owner owner;
    private String storageClass;
    private String uploadId;

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

    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Owner getInitiator() {
        return this.initiator;
    }

    public void setInitiator(Owner owner) {
        this.initiator = owner;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public Date getInitiated() {
        return this.initiated;
    }

    public void setInitiated(Date date) {
        this.initiated = date;
    }
}
