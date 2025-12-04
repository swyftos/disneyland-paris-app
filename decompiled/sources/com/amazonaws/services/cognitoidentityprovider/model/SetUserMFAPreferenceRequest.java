package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class SetUserMFAPreferenceRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private SMSMfaSettingsType sMSMfaSettings;
    private SoftwareTokenMfaSettingsType softwareTokenMfaSettings;

    public SMSMfaSettingsType getSMSMfaSettings() {
        return this.sMSMfaSettings;
    }

    public void setSMSMfaSettings(SMSMfaSettingsType sMSMfaSettingsType) {
        this.sMSMfaSettings = sMSMfaSettingsType;
    }

    public SetUserMFAPreferenceRequest withSMSMfaSettings(SMSMfaSettingsType sMSMfaSettingsType) {
        this.sMSMfaSettings = sMSMfaSettingsType;
        return this;
    }

    public SoftwareTokenMfaSettingsType getSoftwareTokenMfaSettings() {
        return this.softwareTokenMfaSettings;
    }

    public void setSoftwareTokenMfaSettings(SoftwareTokenMfaSettingsType softwareTokenMfaSettingsType) {
        this.softwareTokenMfaSettings = softwareTokenMfaSettingsType;
    }

    public SetUserMFAPreferenceRequest withSoftwareTokenMfaSettings(SoftwareTokenMfaSettingsType softwareTokenMfaSettingsType) {
        this.softwareTokenMfaSettings = softwareTokenMfaSettingsType;
        return this;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public SetUserMFAPreferenceRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getSMSMfaSettings() != null) {
            sb.append("SMSMfaSettings: " + getSMSMfaSettings() + ",");
        }
        if (getSoftwareTokenMfaSettings() != null) {
            sb.append("SoftwareTokenMfaSettings: " + getSoftwareTokenMfaSettings() + ",");
        }
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getSMSMfaSettings() == null ? 0 : getSMSMfaSettings().hashCode()) + 31) * 31) + (getSoftwareTokenMfaSettings() == null ? 0 : getSoftwareTokenMfaSettings().hashCode())) * 31) + (getAccessToken() != null ? getAccessToken().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetUserMFAPreferenceRequest)) {
            return false;
        }
        SetUserMFAPreferenceRequest setUserMFAPreferenceRequest = (SetUserMFAPreferenceRequest) obj;
        if ((setUserMFAPreferenceRequest.getSMSMfaSettings() == null) ^ (getSMSMfaSettings() == null)) {
            return false;
        }
        if (setUserMFAPreferenceRequest.getSMSMfaSettings() != null && !setUserMFAPreferenceRequest.getSMSMfaSettings().equals(getSMSMfaSettings())) {
            return false;
        }
        if ((setUserMFAPreferenceRequest.getSoftwareTokenMfaSettings() == null) ^ (getSoftwareTokenMfaSettings() == null)) {
            return false;
        }
        if (setUserMFAPreferenceRequest.getSoftwareTokenMfaSettings() != null && !setUserMFAPreferenceRequest.getSoftwareTokenMfaSettings().equals(getSoftwareTokenMfaSettings())) {
            return false;
        }
        if ((setUserMFAPreferenceRequest.getAccessToken() == null) ^ (getAccessToken() == null)) {
            return false;
        }
        return setUserMFAPreferenceRequest.getAccessToken() == null || setUserMFAPreferenceRequest.getAccessToken().equals(getAccessToken());
    }
}
