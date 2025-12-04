package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class ListUsersRequest extends AmazonWebServiceRequest implements Serializable {
    private List attributesToGet;
    private String filter;
    private Integer limit;
    private String paginationToken;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public ListUsersRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public List<String> getAttributesToGet() {
        return this.attributesToGet;
    }

    public void setAttributesToGet(Collection<String> collection) {
        if (collection == null) {
            this.attributesToGet = null;
        } else {
            this.attributesToGet = new ArrayList(collection);
        }
    }

    public ListUsersRequest withAttributesToGet(String... strArr) {
        if (getAttributesToGet() == null) {
            this.attributesToGet = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.attributesToGet.add(str);
        }
        return this;
    }

    public ListUsersRequest withAttributesToGet(Collection<String> collection) {
        setAttributesToGet(collection);
        return this;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public ListUsersRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public String getPaginationToken() {
        return this.paginationToken;
    }

    public void setPaginationToken(String str) {
        this.paginationToken = str;
    }

    public ListUsersRequest withPaginationToken(String str) {
        this.paginationToken = str;
        return this;
    }

    public String getFilter() {
        return this.filter;
    }

    public void setFilter(String str) {
        this.filter = str;
    }

    public ListUsersRequest withFilter(String str) {
        this.filter = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getAttributesToGet() != null) {
            sb.append("AttributesToGet: " + getAttributesToGet() + ",");
        }
        if (getLimit() != null) {
            sb.append("Limit: " + getLimit() + ",");
        }
        if (getPaginationToken() != null) {
            sb.append("PaginationToken: " + getPaginationToken() + ",");
        }
        if (getFilter() != null) {
            sb.append("Filter: " + getFilter());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getAttributesToGet() == null ? 0 : getAttributesToGet().hashCode())) * 31) + (getLimit() == null ? 0 : getLimit().hashCode())) * 31) + (getPaginationToken() == null ? 0 : getPaginationToken().hashCode())) * 31) + (getFilter() != null ? getFilter().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListUsersRequest)) {
            return false;
        }
        ListUsersRequest listUsersRequest = (ListUsersRequest) obj;
        if ((listUsersRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (listUsersRequest.getUserPoolId() != null && !listUsersRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((listUsersRequest.getAttributesToGet() == null) ^ (getAttributesToGet() == null)) {
            return false;
        }
        if (listUsersRequest.getAttributesToGet() != null && !listUsersRequest.getAttributesToGet().equals(getAttributesToGet())) {
            return false;
        }
        if ((listUsersRequest.getLimit() == null) ^ (getLimit() == null)) {
            return false;
        }
        if (listUsersRequest.getLimit() != null && !listUsersRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if ((listUsersRequest.getPaginationToken() == null) ^ (getPaginationToken() == null)) {
            return false;
        }
        if (listUsersRequest.getPaginationToken() != null && !listUsersRequest.getPaginationToken().equals(getPaginationToken())) {
            return false;
        }
        if ((listUsersRequest.getFilter() == null) ^ (getFilter() == null)) {
            return false;
        }
        return listUsersRequest.getFilter() == null || listUsersRequest.getFilter().equals(getFilter());
    }
}
