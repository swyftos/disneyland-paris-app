package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class ListResourceTagsRequest extends AmazonWebServiceRequest implements Serializable {
    private String keyId;
    private Integer limit;
    private String marker;

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public ListResourceTagsRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public ListResourceTagsRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String str) {
        this.marker = str;
    }

    public ListResourceTagsRequest withMarker(String str) {
        this.marker = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getLimit() != null) {
            sb.append("Limit: " + getLimit() + ",");
        }
        if (getMarker() != null) {
            sb.append("Marker: " + getMarker());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getLimit() == null ? 0 : getLimit().hashCode())) * 31) + (getMarker() != null ? getMarker().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListResourceTagsRequest)) {
            return false;
        }
        ListResourceTagsRequest listResourceTagsRequest = (ListResourceTagsRequest) obj;
        if ((listResourceTagsRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (listResourceTagsRequest.getKeyId() != null && !listResourceTagsRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((listResourceTagsRequest.getLimit() == null) ^ (getLimit() == null)) {
            return false;
        }
        if (listResourceTagsRequest.getLimit() != null && !listResourceTagsRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if ((listResourceTagsRequest.getMarker() == null) ^ (getMarker() == null)) {
            return false;
        }
        return listResourceTagsRequest.getMarker() == null || listResourceTagsRequest.getMarker().equals(getMarker());
    }
}
