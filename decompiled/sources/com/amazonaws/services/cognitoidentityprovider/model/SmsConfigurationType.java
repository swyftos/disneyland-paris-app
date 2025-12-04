package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class SmsConfigurationType implements Serializable {
    private String externalId;
    private String snsCallerArn;

    public String getSnsCallerArn() {
        return this.snsCallerArn;
    }

    public void setSnsCallerArn(String str) {
        this.snsCallerArn = str;
    }

    public SmsConfigurationType withSnsCallerArn(String str) {
        this.snsCallerArn = str;
        return this;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String str) {
        this.externalId = str;
    }

    public SmsConfigurationType withExternalId(String str) {
        this.externalId = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getSnsCallerArn() != null) {
            sb.append("SnsCallerArn: " + getSnsCallerArn() + ",");
        }
        if (getExternalId() != null) {
            sb.append("ExternalId: " + getExternalId());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getSnsCallerArn() == null ? 0 : getSnsCallerArn().hashCode()) + 31) * 31) + (getExternalId() != null ? getExternalId().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SmsConfigurationType)) {
            return false;
        }
        SmsConfigurationType smsConfigurationType = (SmsConfigurationType) obj;
        if ((smsConfigurationType.getSnsCallerArn() == null) ^ (getSnsCallerArn() == null)) {
            return false;
        }
        if (smsConfigurationType.getSnsCallerArn() != null && !smsConfigurationType.getSnsCallerArn().equals(getSnsCallerArn())) {
            return false;
        }
        if ((smsConfigurationType.getExternalId() == null) ^ (getExternalId() == null)) {
            return false;
        }
        return smsConfigurationType.getExternalId() == null || smsConfigurationType.getExternalId().equals(getExternalId());
    }
}
