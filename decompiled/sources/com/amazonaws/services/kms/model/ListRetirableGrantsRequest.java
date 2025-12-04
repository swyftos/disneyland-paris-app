package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class ListRetirableGrantsRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer limit;
    private String marker;
    private String retiringPrincipal;

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public ListRetirableGrantsRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String str) {
        this.marker = str;
    }

    public ListRetirableGrantsRequest withMarker(String str) {
        this.marker = str;
        return this;
    }

    public String getRetiringPrincipal() {
        return this.retiringPrincipal;
    }

    public void setRetiringPrincipal(String str) {
        this.retiringPrincipal = str;
    }

    public ListRetirableGrantsRequest withRetiringPrincipal(String str) {
        this.retiringPrincipal = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getLimit() != null) {
            sb.append("Limit: " + getLimit() + ",");
        }
        if (getMarker() != null) {
            sb.append("Marker: " + getMarker() + ",");
        }
        if (getRetiringPrincipal() != null) {
            sb.append("RetiringPrincipal: " + getRetiringPrincipal());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getLimit() == null ? 0 : getLimit().hashCode()) + 31) * 31) + (getMarker() == null ? 0 : getMarker().hashCode())) * 31) + (getRetiringPrincipal() != null ? getRetiringPrincipal().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListRetirableGrantsRequest)) {
            return false;
        }
        ListRetirableGrantsRequest listRetirableGrantsRequest = (ListRetirableGrantsRequest) obj;
        if ((listRetirableGrantsRequest.getLimit() == null) ^ (getLimit() == null)) {
            return false;
        }
        if (listRetirableGrantsRequest.getLimit() != null && !listRetirableGrantsRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if ((listRetirableGrantsRequest.getMarker() == null) ^ (getMarker() == null)) {
            return false;
        }
        if (listRetirableGrantsRequest.getMarker() != null && !listRetirableGrantsRequest.getMarker().equals(getMarker())) {
            return false;
        }
        if ((listRetirableGrantsRequest.getRetiringPrincipal() == null) ^ (getRetiringPrincipal() == null)) {
            return false;
        }
        return listRetirableGrantsRequest.getRetiringPrincipal() == null || listRetirableGrantsRequest.getRetiringPrincipal().equals(getRetiringPrincipal());
    }
}
