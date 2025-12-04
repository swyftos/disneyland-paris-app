package com.amazonaws.services.s3.model;

/* loaded from: classes2.dex */
public class PartETag {
    private String eTag;
    private int partNumber;

    public PartETag(int i, String str) {
        this.partNumber = i;
        this.eTag = str;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public void setPartNumber(int i) {
        this.partNumber = i;
    }

    public PartETag withPartNumber(int i) {
        this.partNumber = i;
        return this;
    }

    public String getETag() {
        return this.eTag;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public PartETag withETag(String str) {
        this.eTag = str;
        return this;
    }
}
