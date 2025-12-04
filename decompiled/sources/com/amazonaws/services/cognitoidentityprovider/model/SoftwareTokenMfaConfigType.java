package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class SoftwareTokenMfaConfigType implements Serializable {
    private Boolean enabled;

    public Boolean isEnabled() {
        return this.enabled;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean bool) {
        this.enabled = bool;
    }

    public SoftwareTokenMfaConfigType withEnabled(Boolean bool) {
        this.enabled = bool;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getEnabled() != null) {
            sb.append("Enabled: " + getEnabled());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getEnabled() == null ? 0 : getEnabled().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SoftwareTokenMfaConfigType)) {
            return false;
        }
        SoftwareTokenMfaConfigType softwareTokenMfaConfigType = (SoftwareTokenMfaConfigType) obj;
        if ((softwareTokenMfaConfigType.getEnabled() == null) ^ (getEnabled() == null)) {
            return false;
        }
        return softwareTokenMfaConfigType.getEnabled() == null || softwareTokenMfaConfigType.getEnabled().equals(getEnabled());
    }
}
