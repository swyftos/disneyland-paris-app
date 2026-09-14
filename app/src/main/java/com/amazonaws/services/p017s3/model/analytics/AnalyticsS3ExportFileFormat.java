package com.amazonaws.services.p017s3.model.analytics;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public enum AnalyticsS3ExportFileFormat implements Serializable {
    CSV("CSV");

    private final String format;

    AnalyticsS3ExportFileFormat(String str) {
        this.format = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.format;
    }
}
