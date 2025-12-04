package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class CreateUserPoolResult implements Serializable {
    private UserPoolType userPool;

    public UserPoolType getUserPool() {
        return this.userPool;
    }

    public void setUserPool(UserPoolType userPoolType) {
        this.userPool = userPoolType;
    }

    public CreateUserPoolResult withUserPool(UserPoolType userPoolType) {
        this.userPool = userPoolType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPool() != null) {
            sb.append("UserPool: " + getUserPool());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getUserPool() == null ? 0 : getUserPool().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateUserPoolResult)) {
            return false;
        }
        CreateUserPoolResult createUserPoolResult = (CreateUserPoolResult) obj;
        if ((createUserPoolResult.getUserPool() == null) ^ (getUserPool() == null)) {
            return false;
        }
        return createUserPoolResult.getUserPool() == null || createUserPoolResult.getUserPool().equals(getUserPool());
    }
}
