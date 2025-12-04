package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class AnalyticsConfigurationType implements Serializable {
    private String applicationId;
    private String externalId;
    private String roleArn;
    private Boolean userDataShared;

    public String getApplicationId() {
        return this.applicationId;
    }

    public void setApplicationId(String str) {
        this.applicationId = str;
    }

    public AnalyticsConfigurationType withApplicationId(String str) {
        this.applicationId = str;
        return this;
    }

    public String getRoleArn() {
        return this.roleArn;
    }

    public void setRoleArn(String str) {
        this.roleArn = str;
    }

    public AnalyticsConfigurationType withRoleArn(String str) {
        this.roleArn = str;
        return this;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String str) {
        this.externalId = str;
    }

    public AnalyticsConfigurationType withExternalId(String str) {
        this.externalId = str;
        return this;
    }

    public Boolean isUserDataShared() {
        return this.userDataShared;
    }

    public Boolean getUserDataShared() {
        return this.userDataShared;
    }

    public void setUserDataShared(Boolean bool) {
        this.userDataShared = bool;
    }

    public AnalyticsConfigurationType withUserDataShared(Boolean bool) {
        this.userDataShared = bool;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getApplicationId() != null) {
            sb.append("ApplicationId: " + getApplicationId() + ",");
        }
        if (getRoleArn() != null) {
            sb.append("RoleArn: " + getRoleArn() + ",");
        }
        if (getExternalId() != null) {
            sb.append("ExternalId: " + getExternalId() + ",");
        }
        if (getUserDataShared() != null) {
            sb.append("UserDataShared: " + getUserDataShared());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((getApplicationId() == null ? 0 : getApplicationId().hashCode()) + 31) * 31) + (getRoleArn() == null ? 0 : getRoleArn().hashCode())) * 31) + (getExternalId() == null ? 0 : getExternalId().hashCode())) * 31) + (getUserDataShared() != null ? getUserDataShared().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AnalyticsConfigurationType)) {
            return false;
        }
        AnalyticsConfigurationType analyticsConfigurationType = (AnalyticsConfigurationType) obj;
        if ((analyticsConfigurationType.getApplicationId() == null) ^ (getApplicationId() == null)) {
            return false;
        }
        if (analyticsConfigurationType.getApplicationId() != null && !analyticsConfigurationType.getApplicationId().equals(getApplicationId())) {
            return false;
        }
        if ((analyticsConfigurationType.getRoleArn() == null) ^ (getRoleArn() == null)) {
            return false;
        }
        if (analyticsConfigurationType.getRoleArn() != null && !analyticsConfigurationType.getRoleArn().equals(getRoleArn())) {
            return false;
        }
        if ((analyticsConfigurationType.getExternalId() == null) ^ (getExternalId() == null)) {
            return false;
        }
        if (analyticsConfigurationType.getExternalId() != null && !analyticsConfigurationType.getExternalId().equals(getExternalId())) {
            return false;
        }
        if ((analyticsConfigurationType.getUserDataShared() == null) ^ (getUserDataShared() == null)) {
            return false;
        }
        return analyticsConfigurationType.getUserDataShared() == null || analyticsConfigurationType.getUserDataShared().equals(getUserDataShared());
    }
}
