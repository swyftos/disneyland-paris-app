package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class AdminCreateUserResult implements Serializable {
    private UserType user;

    public UserType getUser() {
        return this.user;
    }

    public void setUser(UserType userType) {
        this.user = userType;
    }

    public AdminCreateUserResult withUser(UserType userType) {
        this.user = userType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUser() != null) {
            sb.append("User: " + getUser());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getUser() == null ? 0 : getUser().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminCreateUserResult)) {
            return false;
        }
        AdminCreateUserResult adminCreateUserResult = (AdminCreateUserResult) obj;
        if ((adminCreateUserResult.getUser() == null) ^ (getUser() == null)) {
            return false;
        }
        return adminCreateUserResult.getUser() == null || adminCreateUserResult.getUser().equals(getUser());
    }
}
