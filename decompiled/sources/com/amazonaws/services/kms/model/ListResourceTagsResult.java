package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class ListResourceTagsResult implements Serializable {
    private String nextMarker;
    private List tags = new ArrayList();
    private Boolean truncated;

    public List<Tag> getTags() {
        return this.tags;
    }

    public void setTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            this.tags = new ArrayList(collection);
        }
    }

    public ListResourceTagsResult withTags(Tag... tagArr) {
        if (getTags() == null) {
            this.tags = new ArrayList(tagArr.length);
        }
        for (Tag tag : tagArr) {
            this.tags.add(tag);
        }
        return this;
    }

    public ListResourceTagsResult withTags(Collection<Tag> collection) {
        setTags(collection);
        return this;
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public void setNextMarker(String str) {
        this.nextMarker = str;
    }

    public ListResourceTagsResult withNextMarker(String str) {
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

    public ListResourceTagsResult withTruncated(Boolean bool) {
        this.truncated = bool;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getTags() != null) {
            sb.append("Tags: " + getTags() + ",");
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
        return (((((getTags() == null ? 0 : getTags().hashCode()) + 31) * 31) + (getNextMarker() == null ? 0 : getNextMarker().hashCode())) * 31) + (getTruncated() != null ? getTruncated().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListResourceTagsResult)) {
            return false;
        }
        ListResourceTagsResult listResourceTagsResult = (ListResourceTagsResult) obj;
        if ((listResourceTagsResult.getTags() == null) ^ (getTags() == null)) {
            return false;
        }
        if (listResourceTagsResult.getTags() != null && !listResourceTagsResult.getTags().equals(getTags())) {
            return false;
        }
        if ((listResourceTagsResult.getNextMarker() == null) ^ (getNextMarker() == null)) {
            return false;
        }
        if (listResourceTagsResult.getNextMarker() != null && !listResourceTagsResult.getNextMarker().equals(getNextMarker())) {
            return false;
        }
        if ((listResourceTagsResult.getTruncated() == null) ^ (getTruncated() == null)) {
            return false;
        }
        return listResourceTagsResult.getTruncated() == null || listResourceTagsResult.getTruncated().equals(getTruncated());
    }
}
