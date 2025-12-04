package com.amazonaws.services.s3.model.inventory;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class InventoryS3BucketDestination implements Serializable {
    private String accountId;
    private String bucketArn;
    private String format;
    private String prefix;

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public InventoryS3BucketDestination withAccountId(String str) {
        setAccountId(str);
        return this;
    }

    public String getBucketArn() {
        return this.bucketArn;
    }

    public void setBucketArn(String str) {
        this.bucketArn = str;
    }

    public InventoryS3BucketDestination withBucketArn(String str) {
        setBucketArn(str);
        return this;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public void setFormat(InventoryFormat inventoryFormat) {
        setFormat(inventoryFormat == null ? null : inventoryFormat.toString());
    }

    public InventoryS3BucketDestination withFormat(String str) {
        setFormat(str);
        return this;
    }

    public InventoryS3BucketDestination withFormat(InventoryFormat inventoryFormat) {
        setFormat(inventoryFormat);
        return this;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public InventoryS3BucketDestination withPrefix(String str) {
        setPrefix(str);
        return this;
    }
}
