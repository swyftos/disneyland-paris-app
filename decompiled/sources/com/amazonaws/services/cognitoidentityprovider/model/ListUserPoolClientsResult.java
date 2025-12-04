package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class ListUserPoolClientsResult implements Serializable {
    private String nextToken;
    private List userPoolClients;

    public List<UserPoolClientDescription> getUserPoolClients() {
        return this.userPoolClients;
    }

    public void setUserPoolClients(Collection<UserPoolClientDescription> collection) {
        if (collection == null) {
            this.userPoolClients = null;
        } else {
            this.userPoolClients = new ArrayList(collection);
        }
    }

    public ListUserPoolClientsResult withUserPoolClients(UserPoolClientDescription... userPoolClientDescriptionArr) {
        if (getUserPoolClients() == null) {
            this.userPoolClients = new ArrayList(userPoolClientDescriptionArr.length);
        }
        for (UserPoolClientDescription userPoolClientDescription : userPoolClientDescriptionArr) {
            this.userPoolClients.add(userPoolClientDescription);
        }
        return this;
    }

    public ListUserPoolClientsResult withUserPoolClients(Collection<UserPoolClientDescription> collection) {
        setUserPoolClients(collection);
        return this;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public ListUserPoolClientsResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolClients() != null) {
            sb.append("UserPoolClients: " + getUserPoolClients() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getUserPoolClients() == null ? 0 : getUserPoolClients().hashCode()) + 31) * 31) + (getNextToken() != null ? getNextToken().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListUserPoolClientsResult)) {
            return false;
        }
        ListUserPoolClientsResult listUserPoolClientsResult = (ListUserPoolClientsResult) obj;
        if ((listUserPoolClientsResult.getUserPoolClients() == null) ^ (getUserPoolClients() == null)) {
            return false;
        }
        if (listUserPoolClientsResult.getUserPoolClients() != null && !listUserPoolClientsResult.getUserPoolClients().equals(getUserPoolClients())) {
            return false;
        }
        if ((listUserPoolClientsResult.getNextToken() == null) ^ (getNextToken() == null)) {
            return false;
        }
        return listUserPoolClientsResult.getNextToken() == null || listUserPoolClientsResult.getNextToken().equals(getNextToken());
    }
}
