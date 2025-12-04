package com.amazonaws.services.s3.model;

/* loaded from: classes2.dex */
public enum BucketAccelerateStatus {
    Enabled("Enabled"),
    Suspended(BucketVersioningConfiguration.SUSPENDED);

    private final String accelerateStatus;

    public static BucketAccelerateStatus fromValue(String str) throws IllegalArgumentException {
        for (BucketAccelerateStatus bucketAccelerateStatus : values()) {
            if (bucketAccelerateStatus.toString().equals(str)) {
                return bucketAccelerateStatus;
            }
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    BucketAccelerateStatus(String str) {
        this.accelerateStatus = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.accelerateStatus;
    }
}
