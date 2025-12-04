package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class SetUserPoolMfaConfigRequest extends AmazonWebServiceRequest implements Serializable {
    private String mfaConfiguration;
    private SmsMfaConfigType smsMfaConfiguration;
    private SoftwareTokenMfaConfigType softwareTokenMfaConfiguration;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public SetUserPoolMfaConfigRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public SmsMfaConfigType getSmsMfaConfiguration() {
        return this.smsMfaConfiguration;
    }

    public void setSmsMfaConfiguration(SmsMfaConfigType smsMfaConfigType) {
        this.smsMfaConfiguration = smsMfaConfigType;
    }

    public SetUserPoolMfaConfigRequest withSmsMfaConfiguration(SmsMfaConfigType smsMfaConfigType) {
        this.smsMfaConfiguration = smsMfaConfigType;
        return this;
    }

    public SoftwareTokenMfaConfigType getSoftwareTokenMfaConfiguration() {
        return this.softwareTokenMfaConfiguration;
    }

    public void setSoftwareTokenMfaConfiguration(SoftwareTokenMfaConfigType softwareTokenMfaConfigType) {
        this.softwareTokenMfaConfiguration = softwareTokenMfaConfigType;
    }

    public SetUserPoolMfaConfigRequest withSoftwareTokenMfaConfiguration(SoftwareTokenMfaConfigType softwareTokenMfaConfigType) {
        this.softwareTokenMfaConfiguration = softwareTokenMfaConfigType;
        return this;
    }

    public String getMfaConfiguration() {
        return this.mfaConfiguration;
    }

    public void setMfaConfiguration(String str) {
        this.mfaConfiguration = str;
    }

    public SetUserPoolMfaConfigRequest withMfaConfiguration(String str) {
        this.mfaConfiguration = str;
        return this;
    }

    public void setMfaConfiguration(UserPoolMfaType userPoolMfaType) {
        this.mfaConfiguration = userPoolMfaType.toString();
    }

    public SetUserPoolMfaConfigRequest withMfaConfiguration(UserPoolMfaType userPoolMfaType) {
        this.mfaConfiguration = userPoolMfaType.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getSmsMfaConfiguration() != null) {
            sb.append("SmsMfaConfiguration: " + getSmsMfaConfiguration() + ",");
        }
        if (getSoftwareTokenMfaConfiguration() != null) {
            sb.append("SoftwareTokenMfaConfiguration: " + getSoftwareTokenMfaConfiguration() + ",");
        }
        if (getMfaConfiguration() != null) {
            sb.append("MfaConfiguration: " + getMfaConfiguration());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getSmsMfaConfiguration() == null ? 0 : getSmsMfaConfiguration().hashCode())) * 31) + (getSoftwareTokenMfaConfiguration() == null ? 0 : getSoftwareTokenMfaConfiguration().hashCode())) * 31) + (getMfaConfiguration() != null ? getMfaConfiguration().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetUserPoolMfaConfigRequest)) {
            return false;
        }
        SetUserPoolMfaConfigRequest setUserPoolMfaConfigRequest = (SetUserPoolMfaConfigRequest) obj;
        if ((setUserPoolMfaConfigRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (setUserPoolMfaConfigRequest.getUserPoolId() != null && !setUserPoolMfaConfigRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((setUserPoolMfaConfigRequest.getSmsMfaConfiguration() == null) ^ (getSmsMfaConfiguration() == null)) {
            return false;
        }
        if (setUserPoolMfaConfigRequest.getSmsMfaConfiguration() != null && !setUserPoolMfaConfigRequest.getSmsMfaConfiguration().equals(getSmsMfaConfiguration())) {
            return false;
        }
        if ((setUserPoolMfaConfigRequest.getSoftwareTokenMfaConfiguration() == null) ^ (getSoftwareTokenMfaConfiguration() == null)) {
            return false;
        }
        if (setUserPoolMfaConfigRequest.getSoftwareTokenMfaConfiguration() != null && !setUserPoolMfaConfigRequest.getSoftwareTokenMfaConfiguration().equals(getSoftwareTokenMfaConfiguration())) {
            return false;
        }
        if ((setUserPoolMfaConfigRequest.getMfaConfiguration() == null) ^ (getMfaConfiguration() == null)) {
            return false;
        }
        return setUserPoolMfaConfigRequest.getMfaConfiguration() == null || setUserPoolMfaConfigRequest.getMfaConfiguration().equals(getMfaConfiguration());
    }
}
