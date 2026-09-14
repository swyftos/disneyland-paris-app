package com.amazonaws.services.p017s3.model.metrics;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class MetricsConfiguration implements Serializable {
    private MetricsFilter filter;

    /* JADX INFO: renamed from: id */
    private String f394id;

    public String getId() {
        return this.f394id;
    }

    public void setId(String str) {
        this.f394id = str;
    }

    public MetricsConfiguration withId(String str) {
        setId(str);
        return this;
    }

    public MetricsFilter getFilter() {
        return this.filter;
    }

    public void setFilter(MetricsFilter metricsFilter) {
        this.filter = metricsFilter;
    }

    public MetricsConfiguration withFilter(MetricsFilter metricsFilter) {
        setFilter(metricsFilter);
        return this;
    }
}
