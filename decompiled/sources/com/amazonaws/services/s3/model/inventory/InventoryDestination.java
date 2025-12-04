package com.amazonaws.services.s3.model.inventory;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class InventoryDestination implements Serializable {
    private InventoryS3BucketDestination s3BucketDestination;

    public InventoryS3BucketDestination getS3BucketDestination() {
        return this.s3BucketDestination;
    }

    public void setS3BucketDestination(InventoryS3BucketDestination inventoryS3BucketDestination) {
        this.s3BucketDestination = inventoryS3BucketDestination;
    }

    public InventoryDestination withS3BucketDestination(InventoryS3BucketDestination inventoryS3BucketDestination) {
        setS3BucketDestination(inventoryS3BucketDestination);
        return this;
    }
}
