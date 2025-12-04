package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class ListUsersResult implements Serializable {
    private String paginationToken;
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

    public ListUsersResult withUsers(UserType... userTypeArr) {
        if (getUsers() == null) {
            this.users = new ArrayList(userTypeArr.length);
        }
        for (UserType userType : userTypeArr) {
            this.users.add(userType);
        }
        return this;
    }

    public ListUsersResult withUsers(Collection<UserType> collection) {
        setUsers(collection);
        return this;
    }

    public String getPaginationToken() {
        return this.paginationToken;
    }

    public void setPaginationToken(String str) {
        this.paginationToken = str;
    }

    public ListUsersResult withPaginationToken(String str) {
        this.paginationToken = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUsers() != null) {
            sb.append("Users: " + getUsers() + ",");
        }
        if (getPaginationToken() != null) {
            sb.append("PaginationToken: " + getPaginationToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getUsers() == null ? 0 : getUsers().hashCode()) + 31) * 31) + (getPaginationToken() != null ? getPaginationToken().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListUsersResult)) {
            return false;
        }
        ListUsersResult listUsersResult = (ListUsersResult) obj;
        if ((listUsersResult.getUsers() == null) ^ (getUsers() == null)) {
            return false;
        }
        if (listUsersResult.getUsers() != null && !listUsersResult.getUsers().equals(getUsers())) {
            return false;
        }
        if ((listUsersResult.getPaginationToken() == null) ^ (getPaginationToken() == null)) {
            return false;
        }
        return listUsersResult.getPaginationToken() == null || listUsersResult.getPaginationToken().equals(getPaginationToken());
    }
}
