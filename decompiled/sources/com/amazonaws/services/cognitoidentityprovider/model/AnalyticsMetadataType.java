package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class AnalyticsMetadataType implements Serializable {
    private String analyticsEndpointId;

    public String getAnalyticsEndpointId() {
        return this.analyticsEndpointId;
    }

    public void setAnalyticsEndpointId(String str) {
        this.analyticsEndpointId = str;
    }

    public AnalyticsMetadataType withAnalyticsEndpointId(String str) {
        this.analyticsEndpointId = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAnalyticsEndpointId() != null) {
            sb.append("AnalyticsEndpointId: " + getAnalyticsEndpointId());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getAnalyticsEndpointId() == null ? 0 : getAnalyticsEndpointId().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AnalyticsMetadataType)) {
            return false;
        }
        AnalyticsMetadataType analyticsMetadataType = (AnalyticsMetadataType) obj;
        if ((analyticsMetadataType.getAnalyticsEndpointId() == null) ^ (getAnalyticsEndpointId() == null)) {
            return false;
        }
        return analyticsMetadataType.getAnalyticsEndpointId() == null || analyticsMetadataType.getAnalyticsEndpointId().equals(getAnalyticsEndpointId());
    }
}
