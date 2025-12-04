package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class UsernameConfigurationType implements Serializable {
    private Boolean caseSensitive;

    public Boolean isCaseSensitive() {
        return this.caseSensitive;
    }

    public Boolean getCaseSensitive() {
        return this.caseSensitive;
    }

    public void setCaseSensitive(Boolean bool) {
        this.caseSensitive = bool;
    }

    public UsernameConfigurationType withCaseSensitive(Boolean bool) {
        this.caseSensitive = bool;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCaseSensitive() != null) {
            sb.append("CaseSensitive: " + getCaseSensitive());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getCaseSensitive() == null ? 0 : getCaseSensitive().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UsernameConfigurationType)) {
            return false;
        }
        UsernameConfigurationType usernameConfigurationType = (UsernameConfigurationType) obj;
        if ((usernameConfigurationType.getCaseSensitive() == null) ^ (getCaseSensitive() == null)) {
            return false;
        }
        return usernameConfigurationType.getCaseSensitive() == null || usernameConfigurationType.getCaseSensitive().equals(getCaseSensitive());
    }
}
