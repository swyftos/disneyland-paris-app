package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class DescribeRiskConfigurationRequest extends AmazonWebServiceRequest implements Serializable {
    private String clientId;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public DescribeRiskConfigurationRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public DescribeRiskConfigurationRequest withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getClientId() != null) {
            sb.append("ClientId: " + getClientId());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getClientId() != null ? getClientId().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeRiskConfigurationRequest)) {
            return false;
        }
        DescribeRiskConfigurationRequest describeRiskConfigurationRequest = (DescribeRiskConfigurationRequest) obj;
        if ((describeRiskConfigurationRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (describeRiskConfigurationRequest.getUserPoolId() != null && !describeRiskConfigurationRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((describeRiskConfigurationRequest.getClientId() == null) ^ (getClientId() == null)) {
            return false;
        }
        return describeRiskConfigurationRequest.getClientId() == null || describeRiskConfigurationRequest.getClientId().equals(getClientId());
    }
}
