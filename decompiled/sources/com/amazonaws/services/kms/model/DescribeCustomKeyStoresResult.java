package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class DescribeCustomKeyStoresResult implements Serializable {
    private List customKeyStores = new ArrayList();
    private String nextMarker;
    private Boolean truncated;

    public List<CustomKeyStoresListEntry> getCustomKeyStores() {
        return this.customKeyStores;
    }

    public void setCustomKeyStores(Collection<CustomKeyStoresListEntry> collection) {
        if (collection == null) {
            this.customKeyStores = null;
        } else {
            this.customKeyStores = new ArrayList(collection);
        }
    }

    public DescribeCustomKeyStoresResult withCustomKeyStores(CustomKeyStoresListEntry... customKeyStoresListEntryArr) {
        if (getCustomKeyStores() == null) {
            this.customKeyStores = new ArrayList(customKeyStoresListEntryArr.length);
        }
        for (CustomKeyStoresListEntry customKeyStoresListEntry : customKeyStoresListEntryArr) {
            this.customKeyStores.add(customKeyStoresListEntry);
        }
        return this;
    }

    public DescribeCustomKeyStoresResult withCustomKeyStores(Collection<CustomKeyStoresListEntry> collection) {
        setCustomKeyStores(collection);
        return this;
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public void setNextMarker(String str) {
        this.nextMarker = str;
    }

    public DescribeCustomKeyStoresResult withNextMarker(String str) {
        this.nextMarker = str;
        return this;
    }

    public Boolean isTruncated() {
        return this.truncated;
    }

    public Boolean getTruncated() {
        return this.truncated;
    }

    public void setTruncated(Boolean bool) {
        this.truncated = bool;
    }

    public DescribeCustomKeyStoresResult withTruncated(Boolean bool) {
        this.truncated = bool;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCustomKeyStores() != null) {
            sb.append("CustomKeyStores: " + getCustomKeyStores() + ",");
        }
        if (getNextMarker() != null) {
            sb.append("NextMarker: " + getNextMarker() + ",");
        }
        if (getTruncated() != null) {
            sb.append("Truncated: " + getTruncated());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getCustomKeyStores() == null ? 0 : getCustomKeyStores().hashCode()) + 31) * 31) + (getNextMarker() == null ? 0 : getNextMarker().hashCode())) * 31) + (getTruncated() != null ? getTruncated().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeCustomKeyStoresResult)) {
            return false;
        }
        DescribeCustomKeyStoresResult describeCustomKeyStoresResult = (DescribeCustomKeyStoresResult) obj;
        if ((describeCustomKeyStoresResult.getCustomKeyStores() == null) ^ (getCustomKeyStores() == null)) {
            return false;
        }
        if (describeCustomKeyStoresResult.getCustomKeyStores() != null && !describeCustomKeyStoresResult.getCustomKeyStores().equals(getCustomKeyStores())) {
            return false;
        }
        if ((describeCustomKeyStoresResult.getNextMarker() == null) ^ (getNextMarker() == null)) {
            return false;
        }
        if (describeCustomKeyStoresResult.getNextMarker() != null && !describeCustomKeyStoresResult.getNextMarker().equals(getNextMarker())) {
            return false;
        }
        if ((describeCustomKeyStoresResult.getTruncated() == null) ^ (getTruncated() == null)) {
            return false;
        }
        return describeCustomKeyStoresResult.getTruncated() == null || describeCustomKeyStoresResult.getTruncated().equals(getTruncated());
    }
}
