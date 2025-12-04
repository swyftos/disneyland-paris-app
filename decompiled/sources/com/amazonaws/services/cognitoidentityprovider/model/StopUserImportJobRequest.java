package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class StopUserImportJobRequest extends AmazonWebServiceRequest implements Serializable {
    private String jobId;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public StopUserImportJobRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String getJobId() {
        return this.jobId;
    }

    public void setJobId(String str) {
        this.jobId = str;
    }

    public StopUserImportJobRequest withJobId(String str) {
        this.jobId = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getJobId() != null) {
            sb.append("JobId: " + getJobId());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getJobId() != null ? getJobId().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof StopUserImportJobRequest)) {
            return false;
        }
        StopUserImportJobRequest stopUserImportJobRequest = (StopUserImportJobRequest) obj;
        if ((stopUserImportJobRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (stopUserImportJobRequest.getUserPoolId() != null && !stopUserImportJobRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((stopUserImportJobRequest.getJobId() == null) ^ (getJobId() == null)) {
            return false;
        }
        return stopUserImportJobRequest.getJobId() == null || stopUserImportJobRequest.getJobId().equals(getJobId());
    }
}
