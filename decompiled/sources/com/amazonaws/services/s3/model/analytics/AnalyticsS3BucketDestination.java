package com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class AnalyticsS3BucketDestination implements Serializable {
    private String bucketAccountId;
    private String bucketArn;
    private String format;
    private String prefix;

    public void setFormat(AnalyticsS3ExportFileFormat analyticsS3ExportFileFormat) {
        if (analyticsS3ExportFileFormat == null) {
            setFormat((String) null);
        } else {
            setFormat(analyticsS3ExportFileFormat.toString());
        }
    }

    public AnalyticsS3BucketDestination withFormat(AnalyticsS3ExportFileFormat analyticsS3ExportFileFormat) {
        setFormat(analyticsS3ExportFileFormat);
        return this;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public AnalyticsS3BucketDestination withFormat(String str) {
        setFormat(str);
        return this;
    }

    public String getBucketAccountId() {
        return this.bucketAccountId;
    }

    public void setBucketAccountId(String str) {
        this.bucketAccountId = str;
    }

    public AnalyticsS3BucketDestination withBucketAccountId(String str) {
        setBucketAccountId(str);
        return this;
    }

    public String getBucketArn() {
        return this.bucketArn;
    }

    public void setBucketArn(String str) {
        this.bucketArn = str;
    }

    public AnalyticsS3BucketDestination withBucketArn(String str) {
        setBucketArn(str);
        return this;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public AnalyticsS3BucketDestination withPrefix(String str) {
        setPrefix(str);
        return this;
    }
}
