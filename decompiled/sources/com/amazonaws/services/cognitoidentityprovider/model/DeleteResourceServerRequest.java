package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class DeleteResourceServerRequest extends AmazonWebServiceRequest implements Serializable {
    private String identifier;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public DeleteResourceServerRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public DeleteResourceServerRequest withIdentifier(String str) {
        this.identifier = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getIdentifier() != null) {
            sb.append("Identifier: " + getIdentifier());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getIdentifier() != null ? getIdentifier().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteResourceServerRequest)) {
            return false;
        }
        DeleteResourceServerRequest deleteResourceServerRequest = (DeleteResourceServerRequest) obj;
        if ((deleteResourceServerRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (deleteResourceServerRequest.getUserPoolId() != null && !deleteResourceServerRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((deleteResourceServerRequest.getIdentifier() == null) ^ (getIdentifier() == null)) {
            return false;
        }
        return deleteResourceServerRequest.getIdentifier() == null || deleteResourceServerRequest.getIdentifier().equals(getIdentifier());
    }
}
