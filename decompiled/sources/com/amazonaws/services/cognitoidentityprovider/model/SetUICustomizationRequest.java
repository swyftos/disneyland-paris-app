package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class SetUICustomizationRequest extends AmazonWebServiceRequest implements Serializable {
    private String cSS;
    private String clientId;
    private ByteBuffer imageFile;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public SetUICustomizationRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public SetUICustomizationRequest withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public String getCSS() {
        return this.cSS;
    }

    public void setCSS(String str) {
        this.cSS = str;
    }

    public SetUICustomizationRequest withCSS(String str) {
        this.cSS = str;
        return this;
    }

    public ByteBuffer getImageFile() {
        return this.imageFile;
    }

    public void setImageFile(ByteBuffer byteBuffer) {
        this.imageFile = byteBuffer;
    }

    public SetUICustomizationRequest withImageFile(ByteBuffer byteBuffer) {
        this.imageFile = byteBuffer;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getClientId() != null) {
            sb.append("ClientId: " + getClientId() + ",");
        }
        if (getCSS() != null) {
            sb.append("CSS: " + getCSS() + ",");
        }
        if (getImageFile() != null) {
            sb.append("ImageFile: " + getImageFile());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getClientId() == null ? 0 : getClientId().hashCode())) * 31) + (getCSS() == null ? 0 : getCSS().hashCode())) * 31) + (getImageFile() != null ? getImageFile().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetUICustomizationRequest)) {
            return false;
        }
        SetUICustomizationRequest setUICustomizationRequest = (SetUICustomizationRequest) obj;
        if ((setUICustomizationRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (setUICustomizationRequest.getUserPoolId() != null && !setUICustomizationRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((setUICustomizationRequest.getClientId() == null) ^ (getClientId() == null)) {
            return false;
        }
        if (setUICustomizationRequest.getClientId() != null && !setUICustomizationRequest.getClientId().equals(getClientId())) {
            return false;
        }
        if ((setUICustomizationRequest.getCSS() == null) ^ (getCSS() == null)) {
            return false;
        }
        if (setUICustomizationRequest.getCSS() != null && !setUICustomizationRequest.getCSS().equals(getCSS())) {
            return false;
        }
        if ((setUICustomizationRequest.getImageFile() == null) ^ (getImageFile() == null)) {
            return false;
        }
        return setUICustomizationRequest.getImageFile() == null || setUICustomizationRequest.getImageFile().equals(getImageFile());
    }
}
