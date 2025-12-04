package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class ListKeysResult implements Serializable {
    private List keys = new ArrayList();
    private String nextMarker;
    private Boolean truncated;

    public List<KeyListEntry> getKeys() {
        return this.keys;
    }

    public void setKeys(Collection<KeyListEntry> collection) {
        if (collection == null) {
            this.keys = null;
        } else {
            this.keys = new ArrayList(collection);
        }
    }

    public ListKeysResult withKeys(KeyListEntry... keyListEntryArr) {
        if (getKeys() == null) {
            this.keys = new ArrayList(keyListEntryArr.length);
        }
        for (KeyListEntry keyListEntry : keyListEntryArr) {
            this.keys.add(keyListEntry);
        }
        return this;
    }

    public ListKeysResult withKeys(Collection<KeyListEntry> collection) {
        setKeys(collection);
        return this;
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public void setNextMarker(String str) {
        this.nextMarker = str;
    }

    public ListKeysResult withNextMarker(String str) {
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

    public ListKeysResult withTruncated(Boolean bool) {
        this.truncated = bool;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getKeys() != null) {
            sb.append("Keys: " + getKeys() + ",");
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
        return (((((getKeys() == null ? 0 : getKeys().hashCode()) + 31) * 31) + (getNextMarker() == null ? 0 : getNextMarker().hashCode())) * 31) + (getTruncated() != null ? getTruncated().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListKeysResult)) {
            return false;
        }
        ListKeysResult listKeysResult = (ListKeysResult) obj;
        if ((listKeysResult.getKeys() == null) ^ (getKeys() == null)) {
            return false;
        }
        if (listKeysResult.getKeys() != null && !listKeysResult.getKeys().equals(getKeys())) {
            return false;
        }
        if ((listKeysResult.getNextMarker() == null) ^ (getNextMarker() == null)) {
            return false;
        }
        if (listKeysResult.getNextMarker() != null && !listKeysResult.getNextMarker().equals(getNextMarker())) {
            return false;
        }
        if ((listKeysResult.getTruncated() == null) ^ (getTruncated() == null)) {
            return false;
        }
        return listKeysResult.getTruncated() == null || listKeysResult.getTruncated().equals(getTruncated());
    }
}
