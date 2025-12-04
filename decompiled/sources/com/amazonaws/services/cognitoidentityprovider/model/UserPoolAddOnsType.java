package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class UserPoolAddOnsType implements Serializable {
    private String advancedSecurityMode;

    public String getAdvancedSecurityMode() {
        return this.advancedSecurityMode;
    }

    public void setAdvancedSecurityMode(String str) {
        this.advancedSecurityMode = str;
    }

    public UserPoolAddOnsType withAdvancedSecurityMode(String str) {
        this.advancedSecurityMode = str;
        return this;
    }

    public void setAdvancedSecurityMode(AdvancedSecurityModeType advancedSecurityModeType) {
        this.advancedSecurityMode = advancedSecurityModeType.toString();
    }

    public UserPoolAddOnsType withAdvancedSecurityMode(AdvancedSecurityModeType advancedSecurityModeType) {
        this.advancedSecurityMode = advancedSecurityModeType.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAdvancedSecurityMode() != null) {
            sb.append("AdvancedSecurityMode: " + getAdvancedSecurityMode());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getAdvancedSecurityMode() == null ? 0 : getAdvancedSecurityMode().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UserPoolAddOnsType)) {
            return false;
        }
        UserPoolAddOnsType userPoolAddOnsType = (UserPoolAddOnsType) obj;
        if ((userPoolAddOnsType.getAdvancedSecurityMode() == null) ^ (getAdvancedSecurityMode() == null)) {
            return false;
        }
        return userPoolAddOnsType.getAdvancedSecurityMode() == null || userPoolAddOnsType.getAdvancedSecurityMode().equals(getAdvancedSecurityMode());
    }
}
