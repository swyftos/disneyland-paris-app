package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class ListUsersInGroupResult implements Serializable {
    private String nextToken;
    private List users;

    public List<UserType> getUsers() {
        return this.users;
    }

    public void setUsers(Collection<UserType> collection) {
        if (collection == null) {
            this.users = null;
        } else {
            this.users = new ArrayList(collection);
        }
    }

    public ListUsersInGroupResult withUsers(UserType... userTypeArr) {
        if (getUsers() == null) {
            this.users = new ArrayList(userTypeArr.length);
        }
        for (UserType userType : userTypeArr) {
            this.users.add(userType);
        }
        return this;
    }

    public ListUsersInGroupResult withUsers(Collection<UserType> collection) {
        setUsers(collection);
        return this;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public ListUsersInGroupResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUsers() != null) {
            sb.append("Users: " + getUsers() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getUsers() == null ? 0 : getUsers().hashCode()) + 31) * 31) + (getNextToken() != null ? getNextToken().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListUsersInGroupResult)) {
            return false;
        }
        ListUsersInGroupResult listUsersInGroupResult = (ListUsersInGroupResult) obj;
        if ((listUsersInGroupResult.getUsers() == null) ^ (getUsers() == null)) {
            return false;
        }
        if (listUsersInGroupResult.getUsers() != null && !listUsersInGroupResult.getUsers().equals(getUsers())) {
            return false;
        }
        if ((listUsersInGroupResult.getNextToken() == null) ^ (getNextToken() == null)) {
            return false;
        }
        return listUsersInGroupResult.getNextToken() == null || listUsersInGroupResult.getNextToken().equals(getNextToken());
    }
}
