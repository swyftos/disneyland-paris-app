package com.amazonaws.services.p017s3.model.analytics;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class AnalyticsConfiguration implements Serializable {
    private AnalyticsFilter filter;

    /* JADX INFO: renamed from: id */
    private String f392id;
    private StorageClassAnalysis storageClassAnalysis;

    public String getId() {
        return this.f392id;
    }

    public void setId(String str) {
        this.f392id = str;
    }

    public AnalyticsConfiguration withId(String str) {
        setId(str);
        return this;
    }

    public AnalyticsFilter getFilter() {
        return this.filter;
    }

    public void setFilter(AnalyticsFilter analyticsFilter) {
        this.filter = analyticsFilter;
    }

    public AnalyticsConfiguration withFilter(AnalyticsFilter analyticsFilter) {
        setFilter(analyticsFilter);
        return this;
    }

    public StorageClassAnalysis getStorageClassAnalysis() {
        return this.storageClassAnalysis;
    }

    public void setStorageClassAnalysis(StorageClassAnalysis storageClassAnalysis) {
        this.storageClassAnalysis = storageClassAnalysis;
    }

    public AnalyticsConfiguration withStorageClassAnalysis(StorageClassAnalysis storageClassAnalysis) {
        setStorageClassAnalysis(storageClassAnalysis);
        return this;
    }
}
