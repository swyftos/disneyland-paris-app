package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class ListUserImportJobsRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer maxResults;
    private String paginationToken;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public ListUserImportJobsRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public Integer getMaxResults() {
        return this.maxResults;
    }

    public void setMaxResults(Integer num) {
        this.maxResults = num;
    }

    public ListUserImportJobsRequest withMaxResults(Integer num) {
        this.maxResults = num;
        return this;
    }

    public String getPaginationToken() {
        return this.paginationToken;
    }

    public void setPaginationToken(String str) {
        this.paginationToken = str;
    }

    public ListUserImportJobsRequest withPaginationToken(String str) {
        this.paginationToken = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getMaxResults() != null) {
            sb.append("MaxResults: " + getMaxResults() + ",");
        }
        if (getPaginationToken() != null) {
            sb.append("PaginationToken: " + getPaginationToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getMaxResults() == null ? 0 : getMaxResults().hashCode())) * 31) + (getPaginationToken() != null ? getPaginationToken().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListUserImportJobsRequest)) {
            return false;
        }
        ListUserImportJobsRequest listUserImportJobsRequest = (ListUserImportJobsRequest) obj;
        if ((listUserImportJobsRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (listUserImportJobsRequest.getUserPoolId() != null && !listUserImportJobsRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((listUserImportJobsRequest.getMaxResults() == null) ^ (getMaxResults() == null)) {
            return false;
        }
        if (listUserImportJobsRequest.getMaxResults() != null && !listUserImportJobsRequest.getMaxResults().equals(getMaxResults())) {
            return false;
        }
        if ((listUserImportJobsRequest.getPaginationToken() == null) ^ (getPaginationToken() == null)) {
            return false;
        }
        return listUserImportJobsRequest.getPaginationToken() == null || listUserImportJobsRequest.getPaginationToken().equals(getPaginationToken());
    }
}
