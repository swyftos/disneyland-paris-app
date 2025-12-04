package com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class AnalyticsExportDestination implements Serializable {
    private AnalyticsS3BucketDestination s3BucketDestination;

    public AnalyticsS3BucketDestination getS3BucketDestination() {
        return this.s3BucketDestination;
    }

    public void setS3BucketDestination(AnalyticsS3BucketDestination analyticsS3BucketDestination) {
        this.s3BucketDestination = analyticsS3BucketDestination;
    }

    public AnalyticsExportDestination withS3BucketDestination(AnalyticsS3BucketDestination analyticsS3BucketDestination) {
        setS3BucketDestination(analyticsS3BucketDestination);
        return this;
    }
}
