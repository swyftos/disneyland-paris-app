package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.model.inventory.InventoryConfiguration;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes2.dex */
public class ListBucketInventoryConfigurationsResult implements Serializable {
    private String continuationToken;
    private List inventoryConfigurationList;
    private boolean isTruncated;
    private String nextContinuationToken;

    public List<InventoryConfiguration> getInventoryConfigurationList() {
        return this.inventoryConfigurationList;
    }

    public void setInventoryConfigurationList(List<InventoryConfiguration> list) {
        this.inventoryConfigurationList = list;
    }

    public ListBucketInventoryConfigurationsResult withInventoryConfigurationList(List<InventoryConfiguration> list) {
        setInventoryConfigurationList(list);
        return this;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }

    public ListBucketInventoryConfigurationsResult withTruncated(boolean z) {
        setTruncated(z);
        return this;
    }

    public String getContinuationToken() {
        return this.continuationToken;
    }

    public void setContinuationToken(String str) {
        this.continuationToken = str;
    }

    public ListBucketInventoryConfigurationsResult withContinuationToken(String str) {
        setContinuationToken(str);
        return this;
    }

    public String getNextContinuationToken() {
        return this.nextContinuationToken;
    }

    public void setNextContinuationToken(String str) {
        this.nextContinuationToken = str;
    }

    public ListBucketInventoryConfigurationsResult withNextContinuationToken(String str) {
        setNextContinuationToken(str);
        return this;
    }
}
