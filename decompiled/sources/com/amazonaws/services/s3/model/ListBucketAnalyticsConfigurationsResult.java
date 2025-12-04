package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes2.dex */
public class ListBucketAnalyticsConfigurationsResult implements Serializable {
    private List analyticsConfigurationList;
    private String continuationToken;
    private boolean isTruncated;
    private String nextContinuationToken;

    public List<AnalyticsConfiguration> getAnalyticsConfigurationList() {
        return this.analyticsConfigurationList;
    }

    public void setAnalyticsConfigurationList(List<AnalyticsConfiguration> list) {
        this.analyticsConfigurationList = list;
    }

    public ListBucketAnalyticsConfigurationsResult withAnalyticsConfigurationList(List<AnalyticsConfiguration> list) {
        setAnalyticsConfigurationList(list);
        return this;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }

    public ListBucketAnalyticsConfigurationsResult withTruncated(boolean z) {
        setTruncated(z);
        return this;
    }

    public String getContinuationToken() {
        return this.continuationToken;
    }

    public void setContinuationToken(String str) {
        this.continuationToken = str;
    }

    public ListBucketAnalyticsConfigurationsResult withContinuationToken(String str) {
        setContinuationToken(str);
        return this;
    }

    public String getNextContinuationToken() {
        return this.nextContinuationToken;
    }

    public void setNextContinuationToken(String str) {
        this.nextContinuationToken = str;
    }

    public ListBucketAnalyticsConfigurationsResult withNextContinuationToken(String str) {
        setNextContinuationToken(str);
        return this;
    }
}
