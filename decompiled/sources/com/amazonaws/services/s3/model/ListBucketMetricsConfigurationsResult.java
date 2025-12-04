package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.model.metrics.MetricsConfiguration;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes2.dex */
public class ListBucketMetricsConfigurationsResult implements Serializable {
    private String continuationToken;
    private boolean isTruncated;
    private List metricsConfigurationList;
    private String nextContinuationToken;

    public List<MetricsConfiguration> getMetricsConfigurationList() {
        return this.metricsConfigurationList;
    }

    public void setMetricsConfigurationList(List<MetricsConfiguration> list) {
        this.metricsConfigurationList = list;
    }

    public ListBucketMetricsConfigurationsResult withMetricsConfigurationList(List<MetricsConfiguration> list) {
        setMetricsConfigurationList(list);
        return this;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }

    public ListBucketMetricsConfigurationsResult withTruncated(boolean z) {
        setTruncated(z);
        return this;
    }

    public String getContinuationToken() {
        return this.continuationToken;
    }

    public void setContinuationToken(String str) {
        this.continuationToken = str;
    }

    public ListBucketMetricsConfigurationsResult withContinuationToken(String str) {
        setContinuationToken(str);
        return this;
    }

    public String getNextContinuationToken() {
        return this.nextContinuationToken;
    }

    public void setNextContinuationToken(String str) {
        this.nextContinuationToken = str;
    }

    public ListBucketMetricsConfigurationsResult withNextContinuationToken(String str) {
        setNextContinuationToken(str);
        return this;
    }
}
