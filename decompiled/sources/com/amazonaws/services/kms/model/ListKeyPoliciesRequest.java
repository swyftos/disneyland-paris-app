package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class ListKeyPoliciesRequest extends AmazonWebServiceRequest implements Serializable {
    private String keyId;
    private Integer limit;
    private String marker;

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public ListKeyPoliciesRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public ListKeyPoliciesRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String str) {
        this.marker = str;
    }

    public ListKeyPoliciesRequest withMarker(String str) {
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
        if (obj == null || !(obj instanceof ListKeyPoliciesRequest)) {
            return false;
        }
        ListKeyPoliciesRequest listKeyPoliciesRequest = (ListKeyPoliciesRequest) obj;
        if ((listKeyPoliciesRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (listKeyPoliciesRequest.getKeyId() != null && !listKeyPoliciesRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((listKeyPoliciesRequest.getLimit() == null) ^ (getLimit() == null)) {
            return false;
        }
        if (listKeyPoliciesRequest.getLimit() != null && !listKeyPoliciesRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if ((listKeyPoliciesRequest.getMarker() == null) ^ (getMarker() == null)) {
            return false;
        }
        return listKeyPoliciesRequest.getMarker() == null || listKeyPoliciesRequest.getMarker().equals(getMarker());
    }
}
